package com.co.enggit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }

}
