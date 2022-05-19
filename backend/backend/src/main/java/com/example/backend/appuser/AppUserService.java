package com.example.backend.appuser;

import com.example.backend.jwt.model.JwtRequest;
import com.example.backend.jwt.model.JwtResponse;
import com.example.backend.registration.token.ConfirmationToken;
import com.example.backend.registration.token.ConfirmationTokenService;
import com.example.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;
    private final static String USER_NOT_FOUND_MSG="User with email %s not found";
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByEmail(email).get();

        if (user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    Collections.singleton(getAuthority(user))
            );
        }else{
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email));
        }

    }


    public String signUpUser(AppUser appUser){

        boolean userExists= appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if (userExists){

            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.


            throw new IllegalStateException("Email already taken!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());


        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);
        //Here we have to send confirmation token

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken =new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );


confirmationTokenService.saveConfirmationToken(confirmationToken);

//Here We have to send email
        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String email = jwtRequest.getEmail();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(email, userPassword);

        UserDetails userDetails = loadUserByUsername(email);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        AppUser user = appUserRepository.findByEmail(email).get();
        return new JwtResponse(user, newGeneratedToken);
    }

    private SimpleGrantedAuthority getAuthority(AppUser user) {
        SimpleGrantedAuthority authority;
        AppUserRole role= user.getAppUserRole();
        authority = new SimpleGrantedAuthority("ROLE_" + role);
        return authority;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
