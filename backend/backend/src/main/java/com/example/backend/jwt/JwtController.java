package com.example.backend.jwt;

import com.example.backend.appuser.AppUserService;
import com.example.backend.jwt.model.JwtRequest;
import com.example.backend.jwt.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class JwtController {

    @Autowired
    private AppUserService jwtService;

    @PostMapping("/login")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
