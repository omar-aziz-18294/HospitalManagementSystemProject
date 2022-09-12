package com.example.hospitalmanagementproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class deleteUsers extends AppCompatActivity {

    private Button removeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_users);

        removeButton = findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(deleteUsers.this, "User Removed!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),AdministratorActivity.class);
                startActivity(intent);
            }
        });

    }


}