package com.example.backend.controller.login;

import com.example.backend.appuser.AppUser;
import com.example.backend.registration.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/*
@Service
@AllArgsConstructor
public class LoginService {

    private final EmailValidator emailValidator;

    @Autowired
    private LoginUserRepository loginUserRepository;


    public String login(LoginRequest request) {

        boolean isValidEmail =emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid");
        }
        else{
            AppUser appUser=loginUserRepository.findByUsername(request.getEmail());
            if (appUser==null){
                throw new UsernameNotFoundException("User Not Found!");
            }


        }


        return "Login Success!";
    }

}
*/