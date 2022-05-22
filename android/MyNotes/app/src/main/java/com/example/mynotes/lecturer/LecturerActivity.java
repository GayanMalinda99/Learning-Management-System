package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mynotes.R;
import com.example.mynotes.SelectedCourseActivity;
import com.example.mynotes.adapters.CourseAdapter;
import com.example.mynotes.adapters.LecturerCourseAdapter;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LecturerActivity extends AppCompatActivity {

    public static final String COURSE_NAME = "com.example.mynotes.lecturer.COURSE_NAME" ;
    public static final String COURSE_CODE = "com.example.mynotes.lecturer.COURSE_CODE" ;

    RecyclerView recyclerView ;
    LecturerCourseAdapter.CourseClickListner listner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);

        //Get data from parent
        Intent intent = getIntent() ;
        int lecturerId = Integer.parseInt(intent.getStringExtra("id")) ;

        recyclerView = (RecyclerView)findViewById(R.id.lecturer_recycleview) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button button = findViewById(R.id.lecturer_add_course_button) ;

        Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi courseApi = retrofit.create(CoursesApi.class) ;

       Call<List<Course>> call = courseApi.getCourses() ;

       call.enqueue(new Callback<List<Course>>() {
           @Override
           public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
               List<Course> allCouses = response.body() ;
               List<Course> lecturerCourses = new ArrayList<>();

               for(int i=0; i < allCouses.size(); i++){
                   if(lecturerId == allCouses.get(i).lecturer.getId()){
                       lecturerCourses.add((allCouses.get(i))) ;
                   }
               }

               listner = new LecturerCourseAdapter.CourseClickListner() {
                   @Override
                   public void onItemClick(View view, int position) {
                       openSelectedActivity(lecturerCourses.get(position));
                   }
               } ;

               LecturerCourseAdapter adapter = new
                       LecturerCourseAdapter(LecturerActivity.this, lecturerCourses, listner);
               recyclerView.setAdapter(adapter);
           }

           @Override
           public void onFailure(Call<List<Course>> call, Throwable t) {

           }
       });


    }
    public void openSelectedActivity(Course course){
        Intent intent = new Intent(getApplicationContext(), LecturerSelectedCourseActivity.class) ;
        intent.putExtra(COURSE_NAME, course.title) ;
        intent.putExtra(COURSE_CODE, course.code) ;
        startActivity(intent) ;
    }

    public void openNewCourseActivity(){
        Intent intent = new Intent(this, NewCourseActivity.class) ;
        startActivity(intent);
    }
}

/*
*/

/*Call<String> call = courseApi.getTest() ;
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String msg = response.body() ;
                button.setText(msg);
                //Log.i("messege", response.body()) ;
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                button.setText(t.toString());
            }
        });*/

/**/