package com.example.mynotes.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CoursesApi {
    @GET("courses/{id}")
    Call<List<String>> getEnrolledCourses(@Path("id") String id) ;

    @GET("courses")
    Call<List<String>> getCourses() ;

    @DELETE("courses/delete/{id}/{course_name}")
    Call<Response> dropCourse(@Path("id") String id, @Path("course_name") String courseName) ;

    @POST("courses/add_course/{id}/{course_name}")
    Call<Response> addCourse(@Path("id") String id, @Path("course_name") String course_name) ;

    @GET("courses/marks/{id}/{course_name}")
    Call<Integer> getMarks(@Path("id") String id, @Path("course_name") String course_name) ;
 }
