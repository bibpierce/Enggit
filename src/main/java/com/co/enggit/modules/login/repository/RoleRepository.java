package com.co.enggit.modules.login.repository;

import com.co.enggit.modules.login.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    @Query("select r from Roles r where r.name = ?1")
    Optional<Roles> findByName(String name);
}
