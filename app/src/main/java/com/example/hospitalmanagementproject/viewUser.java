package com.example.hospitalmanagementproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class viewUser extends AppCompatActivity implements View.OnClickListener{

    private Button getPatients, getDoctors;
    private TextView user_docs, users_dets;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference patsRef = db.collection("users").document("patient").collection("type");
    private CollectionReference docsRef = db.collection("users").document("doctor").collection("type");
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        getDoctors = (Button) findViewById(R.id.getDoctors);
        getPatients = (Button) findViewById(R.id.getPatients);

        user_docs = (TextView) findViewById(R.id.text_getdoc1);
        users_dets = (TextView) findViewById(R.id.text_getdoc2);

        getPatients.setOnClickListener(this);
        getDoctors.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getPatients:
                loadPatients();
                break;

            case R.id.getDoctors:
                loadDoctors();
                break;
        }
    }
    private void loadPatients() {
        user_docs.setText("Patients");
        count = 0;

        patsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    String data = "";
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        String cnicnum = documentSnapshot.getString("NID");
                        String email = documentSnapshot.getString("email");
                        String name = documentSnapshot.getString("name");
                        String mobnum = documentSnapshot.getString("phoneNumber");
                        String type = documentSnapshot.getString("type");
                        //String dob = documentSnapshot.getString("dob");



                        data += "NID: " + cnicnum +
                                "\nemail" + email+
                                "\nname: " + name +
                                "\nphoneNumber: " + mobnum +
                                "\ntype" + type +
                                "\n" + "\n";

                        count++;

                    }
                    data += "Total Patients: " + count;
                    users_dets.setText(data.replace("\\n", "\n"));
                } else {
                    Toast.makeText(viewUser.this, "Cannot load patients' data", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void loadDoctors() {
        user_docs.setText("Doctors");
        count = 0;

        docsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    String data = "";
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        String fname = documentSnapshot.getString("firstname");
                        String lname = documentSnapshot.getString("lastname");
                        String speciality = documentSnapshot.getString("speciality");
                        String gender = documentSnapshot.getString("gender");
                        String dob = documentSnapshot.getString("dob");
                        String mobnum = documentSnapshot.getString("contact");
                        String cnicnum = documentSnapshot.getId();

                        if (speciality.equals("cardiology")) {
                            speciality = "Cardiology";
                        } else if (speciality.equals("dermatology")) {
                            speciality = "Dermatology";
                        } else if (speciality.equals("allergyandimmunology")) {
                            speciality = "Allergy and Immunology";
                        } else if (speciality.equals("infectiousdisease")) {
                            speciality = "Infectious Disease";
                        }

                        data += "CNIC: " + cnicnum +
                                "\nFirst Name: " + fname +
                                "\nLast Name: " + lname +
                                "\nSpeciality: " + speciality +
                                "\nGender: " + gender +
                                "\nMobile Number: " + mobnum +
                                "\nDate of Birth: " + dob +
                                "\n" + "\n";

                        count++;

                    }
                    data += "Total Doctors: " + count;
                    users_dets.setText(data.replace("\\n", "\n"));
                } else {
                    Toast.makeText(viewUser.this, "Cannot load doctors' data", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}