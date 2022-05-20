package com.example.mynotes.retrofit;

import com.example.mynotes.model.*;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AppUserApi {

    @POST("api/v1/registration")
    Call<AppUser> save(@Body AppUser appUser);

    @POST("api/v1/registration")
    Call<AppUser> login(@Body AppUser appUser);

    @FormUrlEncoded
    @POST("authenticate")
    @Headers({
            "Accept: application/json",
            "Content-Type: raw",
    })
    Call<ResponseBody> getToken(@Field("email") String email,
                           @Field("userPassword") String password);
}
