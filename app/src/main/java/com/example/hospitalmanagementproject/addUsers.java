package com.example.hospitalmanagementproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class addUsers extends AppCompatActivity {
    private EditText name,phoneNumber,NID,email,password;

    private Button reg_buttonreg;

    private TextView mDisplayDate;
    private Calendar mCurrentCalendar;

    String reg_name, reg_phoneNumber, reg_NID, reg_email, reg_password;

    private boolean state;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public addUsers() {
        // Required empty public constructor
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users);

        name = (EditText) findViewById(R.id.add_doc_fname);

        phoneNumber = (EditText)findViewById(R.id.add_doc_mobnum);
        NID = (EditText) findViewById(R.id.add_doc_cnic);
        email = (EditText)findViewById(R.id.add_doc_addr);
        password = (EditText) findViewById(R.id.add_doc_password);

        reg_buttonreg = (Button) findViewById(R.id.add_doc_buttonreg);
        reg_buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDoctor();
            }
        });
    }

    private void registerDoctor(){
        reg_NID = NID.getText().toString();
        if (reg_NID.length() != 10)
            NID.setError("NID should be of 10 digits");
        else
            NID.setError(null);


        reg_name = name.getText().toString();
        reg_phoneNumber = phoneNumber.getText().toString();
        if (reg_phoneNumber.length() != 11)
            phoneNumber.setError("Phone Number should be of 11 digits");
        else
            phoneNumber.setError(null);

        reg_email = email.getText().toString();
        reg_password = password.getText().toString();
        if (reg_password.length() > 6)
            password.setError(null);
        else
            password.setError("Password should be of 6 characters");


        Map<String, Object> doctor = new HashMap<>();
        doctor.put("fullname", reg_name);
        doctor.put("phoneNumbert", reg_phoneNumber);
        doctor.put("email", reg_email);
        doctor.put("password", reg_password);
        doctor.put("NID", reg_NID);

        if (reg_name.isEmpty() || reg_email.isEmpty()){
            Toast.makeText(addUsers.this, "Please provide all necessary information", Toast.LENGTH_SHORT).show();
            name.setError("Enter full name");
            email.setError("Enter email address");
        }
        else{
            if (NID.getText().length() == 10 ) {
                if (reg_password.length() > 6) {
                    if (phoneNumber.length() == 11) {
                        db.collection("users").document("NID").set(reg_NID)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(addUsers.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(addUsers.this, "Registration Error", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else {
                        Toast.makeText(addUsers.this, "Mobile Number should be of 11 digits", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(addUsers.this, "Password should be of 6 characters", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(addUsers.this, "Please provide correct information", Toast.LENGTH_SHORT).show();
            }

        }

    }
}