package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mynotes.dto.CourseEnrollementDto;
import com.example.mynotes.model.Course;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView test = findViewById(R.id.test_text) ;

        Retrofit retrofit =  new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi api = retrofit.create(CoursesApi.class) ;

        Call<List<Course>> call = api.getCourses() ;
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                String text = response.body().get(1).title+response.body().get(0).title ;
                test.setText(text);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                test.setText(t.toString());
            }
        });

        /*Call<List<Course>> call = api.getTest() ;
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                String text = response.body().get(1).title ;
                test.setText(text);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

                Log.i("messege", t.toString()) ;
                test.setText(t.toString());
            }
        });*/
    }
}