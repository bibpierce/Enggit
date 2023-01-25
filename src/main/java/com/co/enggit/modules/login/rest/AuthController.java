package com.co.enggit.modules.login.rest;

import com.co.enggit.modules.login.model.Users;
import com.co.enggit.modules.login.model.ro.UsersRO;
import com.co.enggit.modules.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ef-jasper
 */

@RestController
@RequestMapping("/api/login")
public class AuthController {

    @Autowired
    UserRepository userRepository;
//    @PostMapping("/user")
//    public ResponseEntity<String> loginSubmit(){
//        return new ResponseEntity<>("Successfully Logged in", HttpStatus.OK);
//    }
    @PostMapping("/list")
    public ResponseEntity<List<Users>> list(@RequestBody UsersRO usersRO){
        List<Users> listOfUsers = userRepository.findAllByUsernameContainsIgnoreCaseOrEmailContainingIgnoreCase(usersRO.getUsername(), usersRO.getEmail());
        return new ResponseEntity<>(listOfUsers,HttpStatus.OK);

    }
}
