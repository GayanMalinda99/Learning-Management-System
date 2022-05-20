package com.example.mynotes.retrofit;

import com.example.mynotes.dto.CourseEnrollementDto;
import com.example.mynotes.model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CoursesApi {
    @GET("api/v1/registeredCourses")
    Call<List<CourseEnrollementDto>> getEnrolledCourses() ;

    @GET("api/v1/course/getcourse")
    Call <List<Course>> getCourses() ;

    @HTTP(method = "DELETE", path = "api/v1/dropCourse", hasBody = true)
    Call<Boolean> deleteSomething(@Body CourseEnrollementDto dropcourse);

    @POST("api/v1/enrolCourse")
    Call<CourseEnrollementDto> addCourse(@Body CourseEnrollementDto course_data) ;

    @GET("api/v1/courses/marks/{course_code}/{id}")
    Call<Integer> getMarks(@Path("course_code") String course_code, @Path("id") String id) ;

    @GET("api/v1/test")
    Call<List<Course>> getTest() ;

    @POST("api/v1/course/addcourse")
    Call<Response> addNewCourse(@Body Course course) ;

    @POST("api/v1/announcement/")
    Call<Response> announce(@Query("announce") String announce) ;
 }
