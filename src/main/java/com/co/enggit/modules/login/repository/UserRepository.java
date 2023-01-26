package com.co.enggit.modules.login.repository;

import com.co.enggit.modules.login.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("""
            select u from Users u
            where upper(u.username) like upper(concat('%', ?1, '%')) or upper(u.email) like upper(concat('%', ?2, '%'))""")
    Optional<Users> findAllByUsernameContainsIgnoreCaseOrEmailContainingIgnoreCase(String username, String email);

    @Query("select u from Users u where u.username = ?1 or u.email = ?2")
    Optional<Users> findByUsernameOrEmail(String username, String email);

    @Query("select (count(u) > 0) from Users u where u.username = ?1")
    Boolean existsByUsername(String username);

    @Query("select (count(u) > 0) from Users u where u.email = ?1")
    Boolean existsByEmail(String email);
}
