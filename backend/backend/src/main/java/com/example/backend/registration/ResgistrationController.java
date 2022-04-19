package com.example.backend.registration;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/registration")
public class ResgistrationController {

    private RegistrationService registrationService;
    public String register(@RequestBody RegistrationRequest request){

        return registrationService.register(request);
    }

}
