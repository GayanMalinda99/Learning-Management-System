package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class  LoginActivity extends AppCompatActivity {

    EditText etEmail,etPassword,etName;
    TextView tvRegister;
    Button btnLogin;

    final String url_Login =  "" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                String Password = etPassword.getText().toString();

                new LoginUser().execute(Email,Password);

            }
        });

    }

    public class LoginUser extends AsyncTask<String , Void , String>
    {

        @Override
        protected String doInBackground(String... strings) {

            String Email = strings[0];
            String Password = strings[1];

            OkHttpClient okHttpClient = new OkHttpClient();

            RequestBody formBody = new FormBody.Builder()
                    .add("user_id",Email)
                    .add("user_password",Password)
                    .build();

            Request request = new Request.Builder()
                    .url(url_Login)
                    .post(formBody)
                    .build();

            Response response = null;

            try {

                response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful())
                {
                    String result = response.body().string();
                    if (result.equalsIgnoreCase("login"))
                    {

                        Intent i = new Intent(LoginActivity.this,
                                DashboardActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Email Password missmatch",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }


}