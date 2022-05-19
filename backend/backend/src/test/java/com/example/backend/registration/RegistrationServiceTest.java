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
    void testConfirmToken() {
        AppUser appUser = new AppUser();
        appUser.setAppUserRole(AppUserRole.STUDENT);
        appUser.setCourse(new HashSet<>());
        appUser.setCourses(new HashSet<>());
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFirstName("Jane");
        appUser.setId(123L);
        appUser.setLastName("Doe");
        appUser.setLocked(true);
        appUser.setMarks(new HashSet<>());
        appUser.setPassword("iloveyou");

        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setAppUser(appUser);
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiredAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        Optional<ConfirmationToken> ofResult = Optional.of(confirmationToken);
        when(this.confirmationTokenService.getToken((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> this.registrationService.confirmToken("ABC123"));
        verify(this.confirmationTokenService).getToken((String) any());
    }


    @Test
    void testConfirmToken2() {
        AppUser appUser = new AppUser();
        appUser.setAppUserRole(AppUserRole.STUDENT);
        appUser.setCourse(new HashSet<>());
        appUser.setCourses(new HashSet<>());
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFirstName("Jane");
        appUser.setId(123L);
        appUser.setLastName("Doe");
        appUser.setLocked(true);
        appUser.setMarks(new HashSet<>());
        appUser.setPassword("iloveyou");
        ConfirmationToken confirmationToken = mock(ConfirmationToken.class);
        when(confirmationToken.getConfirmedAt()).thenReturn(null);
        when(confirmationToken.getExpiredAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(confirmationToken).setAppUser((AppUser) any());
        doNothing().when(confirmationToken).setConfirmedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setCreatedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setExpiredAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setId((Long) any());
        doNothing().when(confirmationToken).setToken((String) any());
        confirmationToken.setAppUser(appUser);
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiredAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        Optional<ConfirmationToken> ofResult = Optional.of(confirmationToken);
        when(this.confirmationTokenService.getToken((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> this.registrationService.confirmToken("ABC123"));
        verify(this.confirmationTokenService).getToken((String) any());
        verify(confirmationToken).getConfirmedAt();
        verify(confirmationToken).getExpiredAt();
        verify(confirmationToken).setAppUser((AppUser) any());
        verify(confirmationToken).setConfirmedAt((LocalDateTime) any());
        verify(confirmationToken).setCreatedAt((LocalDateTime) any());
        verify(confirmationToken).setExpiredAt((LocalDateTime) any());
        verify(confirmationToken).setId((Long) any());
        verify(confirmationToken).setToken((String) any());
    }


    @Test
    void testConfirmToken3() {
        when(this.confirmationTokenService.getToken((String) any())).thenReturn(Optional.empty());

        AppUser appUser = new AppUser();
        appUser.setAppUserRole(AppUserRole.STUDENT);
        appUser.setCourse(new HashSet<>());
        appUser.setCourses(new HashSet<>());
        appUser.setEmail("jane.doe@example.org");
        appUser.setEnabled(true);
        appUser.setFirstName("Jane");
        appUser.setId(123L);
        appUser.setLastName("Doe");
        appUser.setLocked(true);
        appUser.setMarks(new HashSet<>());
        appUser.setPassword("iloveyou");
        ConfirmationToken confirmationToken = mock(ConfirmationToken.class);
        when(confirmationToken.getConfirmedAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(confirmationToken.getExpiredAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(confirmationToken).setAppUser((AppUser) any());
        doNothing().when(confirmationToken).setConfirmedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setCreatedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setExpiredAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setId((Long) any());
        doNothing().when(confirmationToken).setToken((String) any());
        confirmationToken.setAppUser(appUser);
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiredAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        assertThrows(IllegalStateException.class, () -> this.registrationService.confirmToken("ABC123"));
        verify(this.confirmationTokenService).getToken((String) any());
        verify(confirmationToken).setAppUser((AppUser) any());
        verify(confirmationToken).setConfirmedAt((LocalDateTime) any());
        verify(confirmationToken).setCreatedAt((LocalDateTime) any());
        verify(confirmationToken).setExpiredAt((LocalDateTime) any());
        verify(confirmationToken).setId((Long) any());
        verify(confirmationToken).setToken((String) any());
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