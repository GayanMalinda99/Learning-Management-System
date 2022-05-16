package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mynotes.adapters.AllCourseAdapter;
import com.example.mynotes.retrofit.CoursesApi;
import com.example.mynotes.retrofit.*;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AllCources extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cources);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview1) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*Retrofit retrofit = new RetrofitService().getRetrofit() ;
        final CoursesApi allCoursesApi = retrofit.create(CoursesApi.class) ;
        Call<List<String>> call = allCoursesApi.getCourses() ;
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> courseList = response.body() ;
                AllCourseAdapter allCourseAdapter = new AllCourseAdapter(AllCources.this, courseList) ;
                recyclerView.setAdapter(allCourseAdapter);
                allCourseAdapter.getItemCount() ;
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.i("Messege", "Error") ;
            }
        }) ;*/

        //Call<Response> call = allCoursesApi.addCourse()

        List<String> courses = new ArrayList<>() ;
        courses.add("React") ;
        courses.add("Javascript") ;
        courses.add("Kotlin") ;
        courses.add("Java") ;
        courses.add("Python") ;
        AllCourseAdapter allCourseAdapter = new AllCourseAdapter(this, courses) ;
        recyclerView.setAdapter(allCourseAdapter);
        allCourseAdapter.getItemCount() ;
        /*linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);*/
    }
}

// app:layout_constraintEnd_toStartOf="@+id/imageButton"

/*<ImageButton
        android:id="@+id/imageButton"
        android:layout_width="55dp"
        android:layout_height="38dp"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="35dp"
        android:layout_marginEnd="48dp"
        android:layout_marginRight="48dp"
        android:layout_marginBottom="20dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/textView2"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0"
        app:srcCompat="@android:drawable/ic_input_add" />*/