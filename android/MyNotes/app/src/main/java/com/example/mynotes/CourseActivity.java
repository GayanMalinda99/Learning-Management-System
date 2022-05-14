package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    public static final String COURSE_NAME = "com.example.mynotes.COURSE_NAME" ;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        ListView listView = findViewById(R.id.courseList) ;
        List<String> courses = new ArrayList<>() ;
        courses.add("Web Development") ;
        courses.add("Mobile Development") ;
        courses.add("Software Architecture") ;
        courses.add("Descrete Mathematics") ;
        courses.add("Software Validation") ;

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, courses) ;
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Course", courses.get(position)) ;
                String courseName = courses.get(position) ;
                openSelectedCourseActivity(courseName);
            }
        });

        ImageButton imageButton = findViewById(R.id.imageButton1) ;
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAllCoursesActivity();
            }
        }) ;
    }

    public void openAllCoursesActivity(){
        Intent intent = new Intent(this, AllCources.class) ;
        startActivity(intent);
    }

    public void openSelectedCourseActivity(String courseName){
        Intent intent = new Intent(this, SelectedCourseActivity.class) ;
        intent.putExtra(COURSE_NAME, courseName) ;
        startActivity(intent);
    }
}







































































