package com.example.backend.controller;

import com.example.backend.appuser.AppUser;
import com.example.backend.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/getuser")
    public List<AppUser> getUser(){

        return appUserRepository.findAll();
    }

    @PostMapping("/saveuser")
    public String saveUser(){
        return "save User";
    }

    @PutMapping("/updateuser")
    public String updateUser(){
        return "update User";
    }
    @DeleteMapping("/deleteuser")
    public String deleteUser(){
        return "delete User";
    }

    @GetMapping("/student")
    @PreAuthorize("hasRole('STUDENT')")
    public String forStudent(){
        return "for Student";
    }

    @GetMapping("/lecturer")
    @PreAuthorize("hasRole('LECTURER')")
    public String forLearurer(){
        return "for lecturer";
    }


}
