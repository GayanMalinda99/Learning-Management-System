package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail,etPassword,etName,etLname;
    Button btnRegister;

    final String url_Register =  "http:/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.et_name);
        etLname = (EditText) findViewById(R.id.et_Lname);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnRegister = (Button) findViewById(R.id.btn_register);





        btnRegister.setOnClickListener( new View.OnClickListener()
                                           {
                                               @Override
                                               public void onClick(View v) {

                                                   String Name = etName.getText().toString();
                                                   String LName = etLname.getText().toString();
                                                   String Email = etEmail.getText().toString();
                                                   String Password = etPassword.getText().toString();


                                                   new RegisterUser().execute(Name,LName,Email,Password);

                                               }
                                           });
    }

    public class RegisterUser extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {

            String Name = strings[0];
            String Email = strings[1];
            String Password = strings[2];

            String finalURL = url_Register + "?user_name = " + Name +
                    "&user_id= " + Email +
                    "&user_password = " + Password;

            Request request = new Request.Builder()
                    .url(finalURL)
                    .get()
                    .build();

            Response response = null;
            OkHttpClient okHttpClient = new OkHttpClient();
            try {

                response = okHttpClient.newCall(request).execute();

                if (response.isSuccessful())
                {
                    String result = response.body().string();
                    if (result.equalsIgnoreCase("Registered Succesfully"))
                    {
                        Toast.makeText(RegisterActivity.this,
                                "Register succsess",Toast.LENGTH_LONG).show();

                        Intent i = new Intent(RegisterActivity.this,
                                LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else if (result.equalsIgnoreCase("User Already Exist"))
                    {
                        Toast.makeText(RegisterActivity.this,
                                "User Already Exist",Toast.LENGTH_LONG).show();

                    }

                    else
                    {
                        Toast.makeText(RegisterActivity.this,
                                "Try Again !!!",Toast.LENGTH_LONG).show();

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