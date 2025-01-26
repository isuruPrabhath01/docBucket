/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 4:39 PM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.service.impl;

import lk.octal.docbucket.docbucket.service.DocumentService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private final Path rootLocation = Paths.get("src/main/resources/uploads");


    @Override
    public String saveFile(MultipartFile file) throws BadRequestException {
        try {
            if (file.isEmpty()) {
                throw new BadRequestException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new BadRequestException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
            return destinationFile.toString();
        }
        catch (IOException e) {
            throw new BadRequestException("Failed to store file.", e);
        }
    }
}
