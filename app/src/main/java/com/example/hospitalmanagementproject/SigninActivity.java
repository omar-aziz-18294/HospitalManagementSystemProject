package com.example.hospitalmanagementproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    private Button newAppointment;
    //private Button appointments;
    //private Button cancelAppointment;
    private Button logoutButton;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth= FirebaseAuth.getInstance();
        newAppointment=findViewById(R.id.newAppointment);
        //appointments=findViewById(R.id.appointments);
        logoutButton=findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SigninActivity.this,LoginActivity.class));
            }
        });
        newAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this,Book.class));
            }
        });
    }
}