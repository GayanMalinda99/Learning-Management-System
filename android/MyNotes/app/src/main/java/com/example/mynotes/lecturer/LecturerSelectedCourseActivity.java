package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mynotes.R;

public class LecturerSelectedCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_selected_course);

        Button addMarksButton  = findViewById(R.id.add_marks_button) ;
        Button announcementButton = findViewById(R.id.announcement_button) ;

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