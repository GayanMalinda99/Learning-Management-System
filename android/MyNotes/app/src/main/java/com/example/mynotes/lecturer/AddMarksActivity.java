package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mynotes.R;
import com.example.mynotes.adapters.AddMarksAdapter;
import com.example.mynotes.model.AppUser;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddMarksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marks);

        String courseCode = "1" ;

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.add_marks_list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit  = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi coursesApi = retrofit.create(CoursesApi.class) ;

        Call<List<Course>> call = coursesApi.getEnrolledStudents(courseCode) ;

        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List <Course> courseList = response.body() ;
                for(int i =0 ; i <courseList.size(); i++ ){
                    if(courseCode == courseList.get(i).code){

                        List<AppUser> enrolledStudents = new ArrayList<>(courseList.get(i).enrolledStudents) ;
                        AddMarksAdapter addMarksAdapter = new AddMarksAdapter(AddMarksActivity.this, enrolledStudents) ;
                        recyclerView.setAdapter(addMarksAdapter);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

            }
        });

        /*List<String> students = new ArrayList<>() ;
        students.add("SE/2018/005") ;
        students.add("SE/2018/015") ;
        students.add("SE/2018/032") ;
        students.add("SE/2018/023") ;
        students.add("SE/2018/040") ;

        AddMarksAdapter addMarksAdapter = new AddMarksAdapter(this, students) ;
        recyclerView.setAdapter(addMarksAdapter);*/


    }
}