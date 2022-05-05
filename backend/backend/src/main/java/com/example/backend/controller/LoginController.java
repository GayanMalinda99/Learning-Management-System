package com.example.backend.controller;

import com.example.backend.registration.RegistrationRequest;
import com.example.backend.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    private final LoginService loginService;
    @GetMapping
    public String register(@RequestBody LoginRequest request){

        return loginService.login(request);
    }



}