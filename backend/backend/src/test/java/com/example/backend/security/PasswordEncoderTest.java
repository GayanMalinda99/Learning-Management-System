package com.example.backend.security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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


    @Test
    void testBCryptPasswordEncoder() {


        this.passwordEncoder.bCryptPasswordEncoder();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void bCryptPasswordEncoder() {
    }
}

