package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mynotes.R;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AnnouncementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        Retrofit retrofit = new RetrofitClientInstance().getRetrofitInstance() ;
        final CoursesApi api = retrofit.create(CoursesApi.class) ;

        Call<Response> call = api.announce("Helloo") ;

    }
}