package com.example.mynotes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

public class SelectedCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_course);

        Intent intent = getIntent() ;
        String courseName = intent.getStringExtra(CourseActivity.COURSE_NAME) ;
        String marks = "75" ;

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar7);
        toolbar.setTitle(courseName);

        TextView textView_2 = findViewById(R.id.textView5) ;

        textView_2.setText(marks);
    }
}