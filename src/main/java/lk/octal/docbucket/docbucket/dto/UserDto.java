/**
 * Created By Isuru Prabhath
 * Date : 8/19/2024
 * Time : 10:44 PM
 * Project Name : spring-security-service
 */

package lk.octal.docbucket.docbucket.dto;

import lk.octal.docbucket.docbucket.utils.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String username;
    private String password;
    private UserRoles role;
}
