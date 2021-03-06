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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mynotes.adapters.CourseAdapter;
import com.example.mynotes.dto.CourseEnrollementDto;
import com.example.mynotes.lecturer.LecturerActivity;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CourseActivity extends AppCompatActivity {
    public static final String COURSE_CODE = "com.example.mynotes.COURSE_CODE" ;
    public static  final String STUDENT_ID = "com.example.mynotes.STUDENT_ID" ;
    public static  final String COURSE_NAME = "com.example.mynotes.COURSE_NAME" ;
    public static final String ID =  "com.example.mynotes.ID";

    Button btnLogin;
    EditText etEmail,etPassword;
    TextView tvReg;

    Toolbar toolbar;
    private RecyclerView recyclerView ;
    private CourseAdapter.RecycleViewClickListner listner ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        recyclerView = (RecyclerView)findViewById(R.id.course_recycle_view) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button button = findViewById(R.id.add_course_button) ;
        int studentId = 1 ;

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi coursesApi = retrofit.create(CoursesApi.class) ;

       Call<List<CourseEnrollementDto>> call = coursesApi.getEnrolledCourses() ;
       call.enqueue(new Callback<List<CourseEnrollementDto>>() {
           @Override
           public void onResponse(Call<List<CourseEnrollementDto>> call,
                                  Response<List<CourseEnrollementDto>> response) {
               List<CourseEnrollementDto> allEnrolledCourseList = response.body() ;

               List<CourseEnrollementDto> enrolledCourseList = new ArrayList<>();

               for(int i=0; allEnrolledCourseList.size()>i; i++){
                   if(studentId == allEnrolledCourseList.get(i).studentId){
                       enrolledCourseList.add(allEnrolledCourseList.get(i)) ;
                   }
               }

               /*Creating a listner to go to a selected course*/
               listner = new CourseAdapter.RecycleViewClickListner() {
                   @Override
                   public void onItemClick(View view, int position) {
                       openSelectedActivity(enrolledCourseList.get(position).course_name,
                               enrolledCourseList.get(position).code,
                               Integer.toString(enrolledCourseList.get(position).studentId));
                   }
               } ;

               CourseAdapter courseAdapter =
                       new CourseAdapter(CourseActivity.this, enrolledCourseList,listner) ;
               recyclerView.setAdapter(courseAdapter);

                /*button.setText(enrolledCourseList.get(0).course_name); /*To check whats wrong*/

               /*Refreshing*/
               refresh(courseAdapter);
           }

           @Override
           public void onFailure(Call<List<CourseEnrollementDto>> call, Throwable t) {
                Log.i("Error", t.toString()) ;
               button.setText(t.toString());
           }
       });

        /*Making Add Course button directs to AllCourseActivity*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAllCoursesActivity(studentId);
            }
        }) ;

        /*Refresh*/

    }



    public void refresh(CourseAdapter adapter){
        SwipeRefreshLayout swipeRefreshLayout ;
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout) ;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void openAllCoursesActivity(int id){
        Intent intent = new Intent(this, AllCources.class) ;
        intent.putExtra(ID, Integer.toString(id)) ;
        startActivity(intent) ;
    }

    public void openSelectedActivity(String courseName, String courseCode, String studentId){
        Intent intent = new Intent(getApplicationContext(), SelectedCourseActivity.class) ;
        intent.putExtra(COURSE_NAME, courseName) ;
        intent.putExtra(COURSE_CODE, courseCode) ;
        intent.putExtra(STUDENT_ID, studentId) ;
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







































































