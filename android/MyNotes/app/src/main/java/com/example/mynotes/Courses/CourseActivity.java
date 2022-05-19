package com.example.mynotes.Courses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mynotes.R;
import com.example.mynotes.adapters.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    public static final String COURSE_NAME = "com.example.mynotes.COURSE_NAME" ;

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

        //Initializing retrofit and getting the course list
        /*Retrofit retrofit = new RetrofitService().getRetrofit() ;
        final CoursesApi courseApi = retrofit.create(CoursesApi.class) ;
        String id = "1" ;
        Call<List<String>> call = courseApi.getEnrolledCourses(id) ;
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> courseList = response.body() ;

                CourseAdapter courseAdapter = new CourseAdapter(CourseActivity.this, courseList, listner) ;
                recyclerView.setAdapter(courseAdapter);
                courseAdapter.getItemCount() ;

                listner = new CourseAdapter.RecycleViewClickListner() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), SelectedCourseActivity.class) ;
                        intent.putExtra(COURSE_NAME, list.get(position)) ;
                        startActivity(intent);
                    }
                } ;
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.i("Messege", "Error") ;
            }
        });*/

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

    public void openAllCoursesActivity(){
        Intent intent = new Intent(this, AllCourcesActivity.class) ;
        startActivity(intent);
    }

}







































































