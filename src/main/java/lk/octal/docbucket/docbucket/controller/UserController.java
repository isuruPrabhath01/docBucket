/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 11:18 AM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.controller;

import lk.octal.docbucket.docbucket.dto.UserDto;
import lk.octal.docbucket.docbucket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
        try{
            userService.register(userDto);
            return new ResponseEntity<>(userDto.getUsername()+" user registered..!!",HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
