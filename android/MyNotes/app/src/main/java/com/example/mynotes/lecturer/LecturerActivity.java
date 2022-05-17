package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mynotes.R;
import com.example.mynotes.adapters.LecturerCourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class LecturerActivity extends AppCompatActivity {

    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);

        recyclerView = (RecyclerView)findViewById(R.id.lecturer_recycleview) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> courses = new ArrayList<>() ;
        courses.add("Web Development") ;
        courses.add("Mobile Development") ;
        courses.add("Software Architecture") ;
        courses.add("Descrete Mathematics") ;
        courses.add("Software Validation") ;

        LecturerCourseAdapter lecturerCourseAdapter =
                new LecturerCourseAdapter(this,courses) ;
        recyclerView.setAdapter(lecturerCourseAdapter);
        lecturerCourseAdapter.getItemCount() ;

        Button addCourseButton = (Button)findViewById(R.id.lecturer_add_course_button) ;
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewCourseActivity();
            }
        });
    }
    public void openNewCourseActivity(){
        Intent intent = new Intent(this, NewCourseActivity.class) ;
        startActivity(intent);
    }
}