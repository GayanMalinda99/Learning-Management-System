package com.example.mynotes.retrofit;

import com.example.mynotes.dto.CourseEnrollementDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CoursesApi {
    @GET("courses/{id}")
    Call<List<CourseEnrollementDto>> getEnrolledCourses(@Path("id") String id) ;

    @GET("courses/getCourse")
    Call<List<CourseEnrollementDto>> getCourses() ;

    @DELETE("courses/delete/{course_data}/{id}")
    Call<Response> dropCourse(@Path("course_data") CourseEnrollementDto course_data) ;

    @POST("courses/student/{course_data}/{id}")
    Call<Response> addCourse(@Path("course_data") CourseEnrollementDto course_data, @Path("id") String id) ;

    @GET("courses/marks/{course_code}/{id}")
    Call<Integer> getMarks(@Path("course_code") String course_code, @Path("id") String id) ;
 }
