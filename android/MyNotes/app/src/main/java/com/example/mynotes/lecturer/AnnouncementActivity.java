package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotes.R;
import com.example.mynotes.model.Announcement;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AnnouncementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        EditText announcementEdittext = findViewById(R.id.textArea_announcement) ;
        Button sendButton = findViewById(R.id.announcement_button) ;

        //Get data from parent activity
        Intent intent = getIntent() ;
        String courseName = intent.getStringExtra("course_name") ;
        String courseCode = intent.getStringExtra("course_code") ;

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Announcement announcement = new Announcement() ;
                announcement.announcement = announcementEdittext.getText().toString() ;
                announcement.date = "5/22/2022" ;
                announcement.course_code = courseCode ;

                Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
                final CoursesApi api = retrofit.create(CoursesApi.class) ;

                Call<Response> call = api.announce(announcement) ;
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, Response<Response> response) {
                        Log.i("Messege", "Done") ;
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Log.i("Messege", t.toString()) ;
                    }
                });
            }
        });

    }
}