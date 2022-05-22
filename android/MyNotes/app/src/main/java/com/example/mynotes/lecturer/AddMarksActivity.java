package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mynotes.R;
import com.example.mynotes.adapters.AddMarksAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddMarksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marks);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.add_marks_list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> students = new ArrayList<>() ;
        students.add("SE/2018/005") ;
        students.add("SE/2018/015") ;
        students.add("SE/2018/032") ;
        students.add("SE/2018/023") ;
        students.add("SE/2018/040") ;

        AddMarksAdapter addMarksAdapter = new AddMarksAdapter(this, students) ;
        recyclerView.setAdapter(addMarksAdapter);


    }
}