/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 4:25 PM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.controller;

import lk.octal.docbucket.docbucket.service.DocumentService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/create")
    public ResponseEntity<String> addFiles(@RequestParam("file") MultipartFile file){
        try {
            return new ResponseEntity<>(documentService.saveFile(file), HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
