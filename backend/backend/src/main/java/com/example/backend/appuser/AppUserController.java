package com.example.backend.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    public AppUserController() {
    }


    @GetMapping("/getStudent/{id}")
    public AppUser getAppUserById(@PathVariable Long id){

        return appUserRepository.getById(id);
    }
}
