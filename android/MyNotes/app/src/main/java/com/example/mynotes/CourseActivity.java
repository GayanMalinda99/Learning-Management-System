package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.mynotes.adapters.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    public static final String COURSE_NAME = "com.example.mynotes.COURSE_NAME" ;

    Toolbar toolbar;
    private RecyclerView recyclerView ;
    private CourseAdapter.RecycleViewClickListner listner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        recyclerView = (RecyclerView)findViewById(R.id.course_recycle_view) ;

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        List<String> courses = new ArrayList<>() ;
        courses.add("Web Development") ;
        courses.add("Mobile Development") ;
        courses.add("Software Architecture") ;
        courses.add("Descrete Mathematics") ;
        courses.add("Software Validation") ;

        listner = new CourseAdapter.RecycleViewClickListner() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), SelectedCourseActivity.class) ;
                intent.putExtra(COURSE_NAME, courses.get(position)) ;
                startActivity(intent);
            }
        } ;

        CourseAdapter courseAdapter = new CourseAdapter(this, courses, listner) ;
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.getItemCount() ;

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







































































