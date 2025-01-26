/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 12:46 AM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.utils;

import lk.octal.docbucket.docbucket.dto.UserDto;
import lk.octal.docbucket.docbucket.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    @Autowired
    private ModelMapper modelMapper;

    public User userDtoToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

}
