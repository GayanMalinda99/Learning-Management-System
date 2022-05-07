package com.example.backend.controller;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {

    private final String email;
    private final String password;


}