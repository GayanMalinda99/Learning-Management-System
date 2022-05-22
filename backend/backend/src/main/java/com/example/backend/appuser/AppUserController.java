package com.example.backend.appuser;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/appuser")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    public AppUserController() {
    }


    @GetMapping("/getuser/{id}")
    public AppUser getAppUserById(@PathVariable Long id){

        return appUserRepository.getById(id);
    }
    @GetMapping("")
    @PreAuthorize("hasAnyRole('STUDENT','LECTURER')")
    public Optional<AppUser> loadUserByEmail(@RequestHeader String authorization) throws UnsupportedEncodingException, JSONException {
        String payload = authorization.split("\\.")[1];
        String value= new String(Base64.decodeBase64(payload),"UTF-8");
        JSONObject json = new JSONObject(value);
        String  email = json.getString("sub");
        return appUserRepository.findByEmail(email);
    }

    @GetMapping(value = "/test")
    @PreAuthorize("hasRole('STUDENT')")
    public String handleReq(@RequestHeader String authorization) throws UnsupportedEncodingException, JSONException {
        String payload = authorization.split("\\.")[1];
//        System.out.println(payload);
        String value= new String(Base64.decodeBase64(payload),"UTF-8");
        JSONObject json = new JSONObject(value);
        String  email = json.getString("sub");
        return email;
    }

    @GetMapping(value = "/getUser/{email}")
    public AppUser getUserByEmail(@PathVariable String email){
        return appUserRepository.findByemail(email);
    }
}
