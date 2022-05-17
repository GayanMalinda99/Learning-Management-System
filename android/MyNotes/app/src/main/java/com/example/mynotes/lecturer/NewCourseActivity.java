package com.example.mynotes.lecturer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotes.R;
import com.example.mynotes.model.Course;

public class NewCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);

        EditText code = findViewById(R.id.input_code) ;
        EditText title = findViewById(R.id.input_title) ;
        EditText discription = findViewById(R.id.input_description) ;
        Button submitButton = findViewById(R.id.submit_course_button) ;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("messege", code.getText().toString()+" / "+
                        title.getText().toString()+" / "+discription.getText().toString()) ;
                Course course = new Course(
                        code.getText().toString(),
                        title.getText().toString(),
                        discription.getText().toString()
                ) ;
            }
        });
    }
}