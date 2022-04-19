package com.example.backend.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@AllArgsConstructor
@Service
public class EmailValidator implements Predicate<String> {

    private EmailValidator emailValidator;

    @Override
    public boolean test(String s) {

        //Validate the Email
        return false;
    }
}
