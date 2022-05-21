package com.example.mynotes.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.1.102:8080/";   //  http://192.168.8.102:8080/
    static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

    public static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }


    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(getHttpLoggingInterceptor()).build();

            Gson gsno = new GsonBuilder()
                    .setLenient()
                    .create() ;

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gsno))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}