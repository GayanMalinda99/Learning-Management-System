package com.example.backend.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Method under test: {@link PasswordEncoder#bCryptPasswordEncoder()}
     */
    @Test
    void testBCryptPasswordEncoder() {


        this.passwordEncoder.bCryptPasswordEncoder();
    }
}
