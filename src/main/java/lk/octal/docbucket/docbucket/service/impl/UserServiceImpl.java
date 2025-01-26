/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 11:12 AM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.service.impl;

import lk.octal.docbucket.docbucket.dto.UserDto;
import lk.octal.docbucket.docbucket.repo.UserRepo;
import lk.octal.docbucket.docbucket.service.UserService;
import lk.octal.docbucket.docbucket.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private Converter converter;
    @Override
    public void register(UserDto userDto) {
        if(userRepo.existsByUsername(userDto.getUsername()))
            throw new RuntimeException(userDto.getUsername()+" is already exists..!!");
        userRepo.save(converter.userDtoToEntity(userDto));
    }
}
