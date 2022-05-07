package com.example.backend.controller;

import com.example.backend.registration.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final EmailValidator emailValidator;

    public String login(LoginRequest request) {

        boolean isValidEmail =emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid");
        }
        return "Login Success!";
    }

}
