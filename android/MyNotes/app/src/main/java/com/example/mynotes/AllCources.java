package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import com.example.mynotes.adapters.AllCourseAdapter;
import com.example.mynotes.adapters.CourseAdapter;
import com.example.mynotes.dto.CourseEnrollementDto;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.*;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AllCources extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cources);

        Intent intent = getIntent() ;
        int id = Integer.parseInt(intent.getStringExtra(CourseActivity.ID)) ;

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview1) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar3) ;

        Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi coursesApi = retrofit.create(CoursesApi.class) ;

        Call<List<Course>> call = coursesApi.getCourses() ;
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> courseList = response.body() ;

                AllCourseAdapter allCourseAdapter = new AllCourseAdapter(AllCources.this, courseList, id) ;
                recyclerView.setAdapter(allCourseAdapter);

                toolbar.setTitle("working");/*Test*/
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Log.i("Error", t.toString()) ;
                toolbar.setTitle(t.toString());
            }
        });

        swipeRefreshLayout = findViewById(R.id.refresh_all_courses) ;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}

/*Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi allCoursesApi = retrofit.create(CoursesApi.class) ;
        Call<List<CourseEnrollementDto>> call = allCoursesApi.getCourses() ;
        call.enqueue(new Callback<List<CourseEnrollementDto>>() {
            @Override
            public void onResponse(Call<List<CourseEnrollementDto>> call, Response<List<CourseEnrollementDto>> response) {
                List<CourseEnrollementDto> courseList = response.body() ;
                AllCourseAdapter allCourseAdapter = new AllCourseAdapter(AllCources.this, courseList) ;
                recyclerView.setAdapter(allCourseAdapter);
                allCourseAdapter.getItemCount() ;

                swipeRefreshLayout = findViewById(R.id.refresh_all_courses) ;
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        allCourseAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<CourseEnrollementDto>> call, Throwable t) {
                Log.i("Messege", "Error") ;
            }
        }) ;

        //Call<Response> call = allCoursesApi.addCourse()

       /* List<String> courses = new ArrayList<>() ;
        courses.add("React") ;
        courses.add("Javascript") ;
        courses.add("Kotlin") ;
        courses.add("Java") ;
        courses.add("Python") ;
        AllCourseAdapter allCourseAdapter = new AllCourseAdapter(this, courses) ;
        recyclerView.setAdapter(allCourseAdapter);
        allCourseAdapter.getItemCount() ;*/
