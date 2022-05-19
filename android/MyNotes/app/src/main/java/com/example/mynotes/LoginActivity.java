package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mynotes.model.AppUser;
import com.example.mynotes.retrofit.AppUserApi;
import com.example.mynotes.retrofit.RetrofitClientInstance;

import java.util.regex.Pattern;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;


public class  LoginActivity extends AppCompatActivity {



    EditText etEmail,etPassword,etName;
    TextView tvRegister;
    Button btnLogin;

    final String url_Login =  "http:/" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tvRegister = (TextView) findViewById(R.id.tv_register);


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(LoginActivity.this,
                        RegisterActivity.class);
                startActivity(i);
            }
        });

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = etEmail.getText().toString();
                String Password = etPassword.getText().toString().trim();

                AppUser user = new AppUser(Email,Password);
                Log.i("btn","this is working");
                CallRetrofit(user);

                CallLoginService();


            }
        });

    }

    private void CallLoginService() {


            final String email =etEmail.getText().toString();
            final String password = etPassword.getText().toString();

            AppUserApi appUserApi = RetrofitClientInstance.getRetrofitInstance().create(AppUserApi.class);


    }

    private boolean validateEmail()
    {
        String emailInput = etEmail.getText().toString().trim();

        if (emailInput.isEmpty())
        {
            etEmail.setError("Can not be Empty !");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {

            etEmail.setError("Enter Correct Email");
            return false;
        }

        else
        {
            etEmail.setError(null);
            return true;
        }

    }

    public void CallRetrofit(AppUser user) {
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

        AppUserApi appUserApi = retrofit.create(AppUserApi.class);
        //
        Call<AppUser> call = appUserApi.login(user);

        Log.i("call","function called");
        Intent i = new Intent(LoginActivity.this,
                DashboardActivity.class);
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