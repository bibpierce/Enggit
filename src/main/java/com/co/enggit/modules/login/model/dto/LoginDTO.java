package com.co.enggit.modules.login.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {

    private String usernameOrEmail;
    private String password;

}
