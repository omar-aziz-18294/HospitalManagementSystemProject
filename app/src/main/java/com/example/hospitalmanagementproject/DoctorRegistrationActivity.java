package com.example.hospitalmanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DoctorRegistrationActivity extends AppCompatActivity {
    private TextView regPageQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);

        regPageQuestions=findViewById(R.id.regPageQuestions);
        regPageQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent=new Intent(DoctorRegistrationActivity.this,LoginActivity.class);
                startActivity(Intent);
            }
        });
    }
}