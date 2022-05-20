package com.example.backend.jwt.model;

import com.example.backend.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

    private AppUser user;
    private String token;
}
