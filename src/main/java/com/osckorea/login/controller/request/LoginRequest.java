package com.osckorea.login.controller.request;

import com.osckorea.login.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

    private String username;

    private String password;

    private Role role;
}
