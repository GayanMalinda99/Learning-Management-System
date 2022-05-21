package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotes.R;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);

        EditText code = findViewById(R.id.input_code) ;
        EditText title = findViewById(R.id.input_title) ;
        EditText description = findViewById(R.id.input_description) ;
        Button submitButton = findViewById(R.id.submit_course_button) ;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course newCourse = new Course() ;
                newCourse.code = code.getText().toString() ;
                newCourse.title = title.getText().toString() ;
                newCourse.description = description.getText().toString() ;

                Log.i(newCourse.code+newCourse.title, newCourse.description) ;

                Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
                final CoursesApi coursesApi = retrofit.create(CoursesApi.class) ;

                /*Call<String> call = coursesApi.getTest(newCourse) ;
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        submitButton.setText(response.body());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        submitButton.setText(t.toString());
                    }
                });*/

            }
        });
    }
}

/*Call<Response> call = newCourseApi.addNewCourse(newCourse) ;
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, Response<Response> response) {
                        Log.i("Messege", "Working") ;
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Log.i("Error", t.toString()) ;
                    }
                });*/