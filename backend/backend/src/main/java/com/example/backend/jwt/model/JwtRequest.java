package com.example.backend.jwt.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String email;
    private String userPassword;

}
