package com.example.mynotes.Courses;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotes.R;

public class SelectedCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_course);

        Intent intent = getIntent() ;
        String courseName = intent.getStringExtra(CourseActivity.COURSE_NAME) ;
        String id ="1" ;
        String marks = "75" ;

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar7);
        toolbar.setTitle(courseName);

        TextView textView_2 = findViewById(R.id.textView5) ;

        /*Retrofit retrofit = new RetrofitService().getRetrofit() ;
        final CoursesApi marksCourseApi = retrofit.create(CoursesApi.class) ;
        Call<Integer> call = marksCourseApi.getMarks(id, courseName) ;
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