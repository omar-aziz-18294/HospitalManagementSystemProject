package com.example.hospitalmanagementproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdministratorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button viewUsers;
    private Button addUsers;
    private Button deleteUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        viewUsers = findViewById(R.id.viewUsers);
        addUsers = findViewById(R.id.addUsers);
        deleteUsers = findViewById(R.id.deleteUsers);

        viewUsers.setOnClickListener(this);
        addUsers.setOnClickListener(this);
        deleteUsers.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.viewUsers:
                Intent intent = new Intent(getApplicationContext(),viewUser.class);
                startActivity(intent);
                break;

            case R.id.addUsers:
                intent = new Intent(getApplicationContext(), addUsers.class);
                startActivity(intent);
                break;

            case R.id.deleteUsers:
                intent = new Intent(getApplicationContext(), deleteUsers.class);
                startActivity(intent);
                break;
        }
    }
}