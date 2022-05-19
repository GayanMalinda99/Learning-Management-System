package com.example.mynotes.retrofit;

import com.example.mynotes.model.*;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppUserApi {

    @POST("api/v1/registration")
    Call<AppUser> save(@Body AppUser appUser);

    @GET("authenticate")
    Call<AppUser> login(@Body AppUser appUser);
}
