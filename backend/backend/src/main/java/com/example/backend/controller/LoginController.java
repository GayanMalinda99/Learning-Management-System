package com.example.backend.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/login")
public class LoginController {

  private final LoginService loginService;
  @PostMapping
  public String login(@RequestBody LoginRequest request){

    return loginService.login(request);
  }


}