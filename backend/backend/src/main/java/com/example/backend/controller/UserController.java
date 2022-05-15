package com.example.backend.controller;

import com.example.backend.appuser.AppUser;
import com.example.backend.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/getUser")
    public List<AppUser> getUser(){
        return appUserRepository.findAll();
    }

    @PostMapping("/saveUser")
    public String saveUser(){
        return "save User";
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "update User";
    }
    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "delete User";
    }



}
