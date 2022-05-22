package com.example.mynotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextSelection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mynotes.lecturer.LecturerActivity;

import java.util.HashMap;
import java.util.Map;

public class loginActivity2 extends AppCompatActivity {

    Button btnLogin;
    EditText etEmail,etPassword;
    TextView tvReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btnLogin = findViewById(R.id.btn_login);
        etEmail=findViewById(R.id.et_email);
        etPassword=findViewById(R.id.et_password);
        tvReg = findViewById(R.id.tv_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });


                tvReg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent i = new Intent(loginActivity2.this,
                                RegisterActivity.class);
                        startActivity(i);
                    }
                });

    }

    public void login()
    {



        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.3/login/new.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.contains("1"))
                        {
                            Intent i = new Intent(loginActivity2.this,
                                    HomeActivity.class);
                            startActivity(i);
                            finish();


                           }
else if(response.contains("2"))
{
    Intent i = new Intent(loginActivity2.this,
            LecturerActivity.class);
    startActivity(i);
    finish();

}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String> params = new HashMap<>();

               params.put("email",etEmail.getText().toString());
               params.put("password",etPassword.getText().toString());
               return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
}