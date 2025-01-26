/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 11:02 AM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.entity;

import jakarta.persistence.*;
import lk.octal.docbucket.docbucket.utils.UserRoles;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoles role;
}
