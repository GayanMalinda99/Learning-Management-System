package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynotes.model.*;
import com.example.mynotes.retrofit.*;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail,etPassword,etFirstName, etLastName;
    Button btnRegister;


//    final String url_Register =  "http:/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener( new View.OnClickListener()
       {
           @Override
           public void onClick(View v) {
               String firstName = etFirstName.getText().toString();
               String lastName = etLastName.getText().toString();
               String email = etEmail.getText().toString();
               String password =etPassword.getText().toString().trim();
//               Log.i("msg",firstName+ " "+ lastName+" "+ email+" "+password);

               AppUser user = new AppUser(firstName,lastName,email,password);

               Log.i("btn","this is working");
               CallRetrofit(user);
           }
       });
    }

    public void CallRetrofit(AppUser user) {
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

        AppUserApi appUserApi = retrofit.create(AppUserApi.class);
        Call<AppUser> call = appUserApi.save(user);

        Log.i("call","function called");
        Intent i = new Intent(RegisterActivity.this,
                LoginActivity.class);
        startActivity(i);
        finish();
        call.enqueue(new Callback<AppUser>() {
            @Override
            public void onResponse(Call<AppUser> call, retrofit2.Response<AppUser> response) {
                Log.i("save","working");

            }

            @Override
            public void onFailure(Call<AppUser> call, Throwable t) {
//                Log.i("lost","not save");
            }
        });
    }

    
}