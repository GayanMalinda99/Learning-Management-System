package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    EditText etEmail,etPassword,etName;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        intializeComponents();
    }
    private void intializeComponents() {

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnRegister = (Button) findViewById(R.id.btn_register);



        RetrofitService retrofitService = new RetrofitService();
        StudentApi studentApi = retrofitService.getRetrofit().create(StudentApi.class);

        btnRegister.setOnClickListener( View ->
                {
                    String name = String.valueOf(etName.getText());
                    String email = String.valueOf(etEmail.getText());
                    String password = String.valueOf(etPassword.getText());


                    Student student = new Student();
                    student.setName(name);
                    student.setEmail(email);
                    student.setPassword(password);


                    studentApi.save(student)
                            .enqueue(new Callback<Student>() {
                                @Override
                                public void onResponse(Call<Student> call, Response<Student> response) {
                                    Toast.makeText(RegisterActivity.this,"Save Success",Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void onFailure(Call<Student> call, Throwable t) {

                                    Toast.makeText(RegisterActivity.this,"Save Failed",Toast.LENGTH_SHORT).show();
                                    Logger.getLogger(RegisterActivity.class.getName()).log(Level.SEVERE,"Error",t);
                                }
                            });
                }
        );
    }
}