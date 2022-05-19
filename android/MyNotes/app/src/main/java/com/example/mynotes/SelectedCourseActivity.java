package com.example.mynotes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SelectedCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_course);

        Intent intent = getIntent() ;
        String courseName = intent.getStringExtra(CourseActivity.COURSE_NAME) ;
        String courseCode = intent.getStringExtra(CourseActivity.COURSE_CODE) ;
        String studentId = intent.getStringExtra(CourseActivity.STUDENT_ID) ;

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar7);
        toolbar.setTitle(courseName);

        /*String id ="1" ;
        String marks = "75" ;*/
        TextView textView_2 = findViewById(R.id.textView5) ;
        String marks = "75" ;

       /* Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi marksCourseApi = retrofit.create(CoursesApi.class) ;
        Call<Integer> call = marksCourseApi.getMarks(courseCode, studentId) ;
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                int marks = response.body() ;
                textView_2.setText(marks);
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });*/

        textView_2.setText(marks);
    }
}