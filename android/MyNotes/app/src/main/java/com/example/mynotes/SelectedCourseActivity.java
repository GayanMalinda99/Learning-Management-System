package com.example.mynotes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mynotes.model.Marks;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SelectedCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_course);

        Intent intent = getIntent() ;
        String courseName = intent.getStringExtra(CourseActivity.COURSE_NAME) ;
        String courseCode = intent.getStringExtra(CourseActivity.COURSE_CODE) ;
        String studentIdString = intent.getStringExtra(CourseActivity.STUDENT_ID) ;

        Long studentId = new Long(Integer.parseInt(studentIdString)) ;

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar7);
        toolbar.setTitle(courseName);

        TextView textView_2 = findViewById(R.id.textView5) ;
        String marks = "75" ;

       Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
       final CoursesApi api = retrofit.create(CoursesApi.class) ;

       Call<List<Marks>> call = api.getMarks(studentId) ;
       call.enqueue(new Callback<List<Marks>>() {
           @Override
           public void onResponse(Call<List<Marks>> call, Response<List<Marks>> response) {
               List<Marks> markslist = response.body() ;
               for(int i = 0 ; i < markslist.size() ; i++){
                   if(courseCode == markslist.get(i).course_code){
                       textView_2.setText(Long.toString(markslist.get(i).marks));
                   }
               }
           }

           @Override
           public void onFailure(Call<List<Marks>> call, Throwable t) {
                Log.i("Error", t.toString()) ;
           }
       });

        textView_2.setText(marks);
    }
}