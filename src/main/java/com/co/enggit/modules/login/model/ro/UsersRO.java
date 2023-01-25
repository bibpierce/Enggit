package com.co.enggit.modules.login.model.ro;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersRO implements Serializable {

    private String username;
    private String email;
}
