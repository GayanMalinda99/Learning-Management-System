package com.example.backend.registration;

import com.example.backend.appuser.AppUser;
import com.example.backend.appuser.AppUserRole;
import com.example.backend.appuser.AppUserService;
import com.example.backend.email.EmailSender;
import com.example.backend.registration.token.ConfirmationToken;
import com.example.backend.registration.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {RegistrationService.class})
@ExtendWith(SpringExtension.class)
class RegistrationServiceTest {

    @MockBean
    private AppUserService appUserService;

    @MockBean
    private ConfirmationTokenService confirmationTokenService;

    @MockBean
    private EmailSender emailSender;

    @MockBean
    private EmailValidator emailValidator;

    @Autowired
    private RegistrationService registrationService;

    @Test
    void register() {
    }



    @Test
    void confirmToken() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}