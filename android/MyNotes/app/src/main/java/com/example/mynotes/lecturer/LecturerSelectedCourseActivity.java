package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.mynotes.R;

public class LecturerSelectedCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_selected_course);

        Button addMarksButton  = findViewById(R.id.add_marks_button) ;
        Button announcementButton = findViewById(R.id.announcement_button) ;
        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.course_panel_toolbar);

        Intent intent = getIntent() ;
        String courseName = intent.getStringExtra(LecturerActivity.COURSE_NAME) ;
        String courseCode = intent.getStringExtra(LecturerActivity.COURSE_CODE) ;

        toolbar.setTitle(courseName);

        addMarksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddMarksActivity.class) ;
                startActivity(intent);
            }
        });

        announcementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AnnouncementActivity.class) ;
                startActivity(intent);
            }
        });
    }
}