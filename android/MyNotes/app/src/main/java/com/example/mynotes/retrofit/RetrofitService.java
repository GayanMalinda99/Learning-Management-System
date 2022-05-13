package com.example.mynotes.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit = null;




    public RetrofitService()
    {
        intializeRetrofit();
    }

    private void intializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://ip:8080/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
