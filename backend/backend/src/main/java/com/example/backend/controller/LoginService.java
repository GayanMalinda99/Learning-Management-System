package com.example.backend.controller;

import com.example.backend.appuser.AppUserService;
import com.example.backend.email.EmailSender;
import com.example.backend.registration.EmailValidator;
import com.example.backend.registration.RegistrationRequest;
import com.example.backend.registration.token.ConfirmationTokenService;

public class LoginService {


    private final AppUserService appUserService;
    private final EmailValidator emailValidator;



    public String login(LoginRequest request) {

        boolean isValidEmail =emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid");
        }


}
