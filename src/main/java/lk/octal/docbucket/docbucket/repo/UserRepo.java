/**
 * Created By Isuru Prabhath
 * Date : 1/26/2025
 * Time : 11:10 AM
 * Project Name : DocBucket
 */

package lk.octal.docbucket.docbucket.repo;

import lk.octal.docbucket.docbucket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    boolean existsByUsername(String username);
}
