package com.example.backend.controller.login;
import com.example.backend.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/login")
public class LoginController {

 // private final LoginService loginService;

  @GetMapping
  public void getLoginDetails(@RequestBody AppUser appUser){

    System.out.println("User FirstName is:"+appUser.getFirstName());
    System.out.println("User LastName is:"+appUser.getLastName());
    System.out.println("User Email is:"+appUser.getEmail());
    System.out.println("User Password is:"+appUser.getPassword());
    System.out.println("User Role is:"+appUser.getAppUserRole());





  }







}