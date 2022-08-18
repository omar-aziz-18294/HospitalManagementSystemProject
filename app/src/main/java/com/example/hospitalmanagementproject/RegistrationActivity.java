package com.example.hospitalmanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    private TextView back;
    private Button DoctorReg,PatientRag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        back=findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(Intent);
            }
        });

        PatientRag=findViewById(R.id.PatientReg);
        DoctorReg=findViewById(R.id.DoctorReg);

        PatientRag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent=new Intent(RegistrationActivity.this,PatientRegistrationActivity.class);
                startActivity(Intent);
            }
        });

        DoctorReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent=new Intent(RegistrationActivity.this,DoctorRegistrationActivity.class);
                startActivity(Intent);
            }
        });
    }
}