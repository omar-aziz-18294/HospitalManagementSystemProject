package com.example.hospitalmanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class adminLoginActivity extends AppCompatActivity {

    private TextInputEditText adminUsername;
    private TextInputEditText adminPassword;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);



        adminUsername=findViewById(R.id.adminUsername);
        adminPassword=findViewById(R.id.adminPassword);
        loginButton=findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adminUsername.getText().toString().equals("admin") &&
                        adminPassword.getText().toString().equals("admin")){
                    Intent Intent=new Intent(adminLoginActivity.this,AdministratorActivity.class);
                    startActivity(Intent);
                }
            }
        });

    }

}
