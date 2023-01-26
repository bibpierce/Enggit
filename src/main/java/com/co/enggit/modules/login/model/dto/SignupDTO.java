package com.co.enggit.modules.login.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignupDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String mobile;

}
