package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynotes.model.Student;
import com.example.mynotes.retrofit.RetrofitService;
import com.example.mynotes.retrofit.StudentApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail,etPassword,etName,etLname;
    Button btnRegister;

    final String url_Login =  "http:/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        intializeComponents();
    }
    private void intializeComponents() {

        etName = (EditText) findViewById(R.id.et_name);
        etLname = (EditText) findViewById(R.id.et_Lname);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnRegister = (Button) findViewById(R.id.btn_register);



        btnRegister.setOnClickListener( new View.OnClickListener()
                                           {
                                               @Override
                                               public void onClick(View v) {

                                               }
                                           });
    }
}