package com.example.mynotes.retrofit;

import com.example.mynotes.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface StudentApi {

    @POST("/student/save")
    Call<Student> save(@Body Student student);
}
