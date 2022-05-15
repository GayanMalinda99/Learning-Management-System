package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mynotes.adapters.AllCourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllCources extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cources);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview1) ;

        List<String> courses = new ArrayList<>() ;
        courses.add("React") ;
        courses.add("Javascript") ;
        courses.add("Kotlin") ;
        courses.add("Java") ;
        courses.add("Python") ;

        AllCourseAdapter allCourseAdapter = new AllCourseAdapter(this, courses) ;
        recyclerView.setAdapter(allCourseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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