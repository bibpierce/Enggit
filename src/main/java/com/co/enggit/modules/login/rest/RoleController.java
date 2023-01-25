package com.co.enggit.modules.login.rest;

import com.co.enggit.modules.login.model.Roles;
import com.co.enggit.modules.login.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/role/{id}")
    public Optional<Roles> getRoleById(@PathVariable Long id){
        return roleRepository.findById(id);
    }
}
