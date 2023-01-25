package com.co.enggit.modules.login.repository;

import com.co.enggit.modules.login.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("""
            select u from Users u
            where upper(u.username) like upper(concat('%', ?1, '%')) or upper(u.email) like upper(concat('%', ?2, '%'))""")
    List<Users> findAllByUsernameContainsIgnoreCaseOrEmailContainingIgnoreCase(String username, String email);

}
