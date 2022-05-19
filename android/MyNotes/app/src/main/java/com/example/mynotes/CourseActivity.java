package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.mynotes.adapters.CourseAdapter;
import com.example.mynotes.dto.CourseEnrollementDto;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.*;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CourseActivity extends AppCompatActivity {
    public static final String COURSE_CODE = "com.example.mynotes.COURSE_NAME" ;
    public static  final String STUDENT_ID = "com.example.mynotes.STUDENT_ID" ;
    public static  final String COURSE_NAME = "com.example.mynotes.COURSE_NAME" ;


    Toolbar toolbar;
    private RecyclerView recyclerView ;
    private CourseAdapter.RecycleViewClickListner listner ;
    SwipeRefreshLayout swipeRefreshLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Log.i("Messege", "Rendered") ;

        recyclerView = (RecyclerView)findViewById(R.id.course_recycle_view) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.add_course_button) ;
        button.setOnClickListener(new View.OnClickListener() {
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

}

//Initializing retrofit and getting the course list
        /*Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi courseApi = retrofit.create(CoursesApi.class) ;
        String id = "1" ;
        Call<List<CourseEnrollementDto>> call = courseApi.getEnrolledCourses(id) ;
        Call.enqueue(new Callback<List<CourseEnrollementDto>>() {
            @Override
            public void onResponse(Call<List<CourseEnrollementDto>> call, Response<List<CourseEnrollementDto>> response) {
                List<CourseEnrollementDto> courseList = response.body() ;

                CourseAdapter courseAdapter = new CourseAdapter(CourseActivity.this, courseList, listner) ;
                recyclerView.setAdapter(courseAdapter);
                courseAdapter.getItemCount() ;

                listner = new CourseAdapter.RecycleViewClickListner() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), SelectedCourseActivity.class) ;
                        intent.putExtra(COURSE_CODE, courseList.get(position).getCode()) ;
                        intent.putExtra(STUDENT_ID, courseList.get(position).getStudentId()) ;
                        intent.putExtra(COURSE_NAME, courseList.get(position).getCourseName()) ;
                        startActivity(intent);
                    }
                } ;

                Button button = findViewById(R.id.add_course_button) ;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openAllCoursesActivity();
                    }
                }) ;

                swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout) ;
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        courseAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<CourseEnrollementDto>> call, Throwable t) {
                Log.i("Messege", "Error") ;
            }
        });

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
        courseAdapter.getItemCount() ;



        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout) ;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                courseAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout) ;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //courseAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });*/







































































