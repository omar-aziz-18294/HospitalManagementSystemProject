package com.example.hospitalmanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView loginPageQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPageQuestions=findViewById(R.id.loginPageQuestions);
        loginPageQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(Intent);
            }
        });
    }
}