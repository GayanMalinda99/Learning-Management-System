package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DashboardActivity extends AppCompatActivity {

    EditText etEmail,etPassword,etName,etLname;
    Button btnRegister;

    final String url_Login =  "http:/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
}