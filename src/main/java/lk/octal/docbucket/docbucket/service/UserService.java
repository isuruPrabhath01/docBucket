/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 11:12 AM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.service;

import lk.octal.docbucket.docbucket.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(UserDto userDto);
}
