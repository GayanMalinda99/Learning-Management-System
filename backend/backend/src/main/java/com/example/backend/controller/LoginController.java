package com.example.backend.controller;


import com.example.backend.registration.RegistrationRequest;
import com.example.backend.registration.RegistrationService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {
/*
  @GetMapping("/login")
    public String login(){

    return "login";
  }
*/
  private final LoginService loginService;
  @PostMapping
  public String login(@RequestBody LoginRequest request){

    return loginService.login(request);
  }


}