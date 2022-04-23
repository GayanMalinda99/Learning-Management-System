package com.example.backend.controller;

import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class UserController {


    @GetMapping("/getUser")
    public String getUser(){
        return "Getting User";
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
