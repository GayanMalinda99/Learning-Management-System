package com.example.backend.controller;


import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

  @GetMapping("/login")
    public String login(){
      return "login";
  }



}