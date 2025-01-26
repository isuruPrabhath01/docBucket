/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 11:12 AM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.service.impl;

import lk.octal.docbucket.docbucket.dto.UserDto;
import lk.octal.docbucket.docbucket.entity.User;
import lk.octal.docbucket.docbucket.repo.UserRepo;
import lk.octal.docbucket.docbucket.service.UserService;
import lk.octal.docbucket.docbucket.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepo.findByUsername(username);
        if (byUsername.isPresent()){
            User user = byUsername.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(String.valueOf(user.getRole()))
                    .build();
        }else
            throw new UsernameNotFoundException(username);

    }
}
