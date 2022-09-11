package com.example.hospitalmanagementproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private TextInputEditText loginEmail;
    private TextInputEditText loginPassword;
    private View loginPageQuestions;
    private View admin;

    ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("SigninButtonActivity");
        mAuth = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        loginPageQuestions = findViewById(R.id.loginPageQuestions);
        admin = findViewById(R.id.admin);
        progressbar = findViewById(R.id.progressBar);

        loginButton.setOnClickListener(this);
        loginPageQuestions.setOnClickListener(this);
        admin.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                userlogin();
                break;

            case R.id.loginPageQuestions:
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
                break;

            case R.id.admin:
                intent = new Intent(getApplicationContext(), adminLoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userlogin() {
        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

        if (email.isEmpty()) {
            loginEmail.setError("Email cannot be empty");
            loginEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginEmail.setError("Enter a valid Email Address");
            loginEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            loginPassword.requestFocus();
            return;
        }
        if (password.length()< 6){
            loginPassword.setError("Minimum length of a password should be 6 ");
            return;
        }
        progressbar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "Log in Error: ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}