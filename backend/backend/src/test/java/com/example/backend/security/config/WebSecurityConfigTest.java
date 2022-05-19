package com.example.backend.security.config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.example.backend.appuser.AppUserRepository;
import com.example.backend.appuser.AppUserService;
import com.example.backend.registration.token.ConfirmationTokenRepository;
import com.example.backend.registration.token.ConfirmationTokenService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class WebSecurityConfigTest {
    /**
     * Method under test: {@link WebSecurityConfig#daoAuthenticationProvider()}
     */
    @Test
    void testDaoAuthenticationProvider() {


//        AppUserRepository appUserRepository = mock(AppUserRepository.class);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        AppUserService appUserService = new AppUserService(appUserRepository, bCryptPasswordEncoder,
//                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));
//
//        DaoAuthenticationProvider actualDaoAuthenticationProviderResult = (new WebSecurityConfig(appUserService,
//                new BCryptPasswordEncoder())).daoAuthenticationProvider();
//        assertTrue(actualDaoAuthenticationProviderResult
//                .getUserCache() instanceof org.springframework.security.core.userdetails.cache.NullUserCache);
//        assertTrue(actualDaoAuthenticationProviderResult.isHideUserNotFoundExceptions());
//        assertFalse(actualDaoAuthenticationProviderResult.isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link WebSecurityConfig#daoAuthenticationProvider()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDaoAuthenticationProvider2() {


//
//        AppUserRepository appUserRepository = mock(AppUserRepository.class);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        (new WebSecurityConfig(new AppUserService(appUserRepository, bCryptPasswordEncoder,
//                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class))), null)).daoAuthenticationProvider();
    }
}

