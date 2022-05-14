package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_course);

        Intent intent = getIntent() ;
        String courseName = intent.getStringExtra(CourseActivity.COURSE_NAME) ;
        TextView textView = findViewById(R.id.textView3) ;
        textView.setText(courseName);
    }
}