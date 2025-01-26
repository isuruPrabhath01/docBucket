/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 4:38 PM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.service;

import org.apache.coyote.BadRequestException;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    String saveFile(MultipartFile file) throws BadRequestException;
}
