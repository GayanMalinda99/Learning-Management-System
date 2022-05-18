package com.example.backend.controller.login;

import com.example.backend.appuser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    private LoginUserRepository loginUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser user =loginUserRepository.findByUserEmail(username);
//        if (user==null){
//            throw new UsernameNotFoundException("Not Found USer");
//        }
//        return new CustomUserDetails(user);
//    }
//}
