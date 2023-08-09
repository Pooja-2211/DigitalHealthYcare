package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class Co_Profile extends AppCompatActivity {
    TextView manage_patient,manage_appointment,manage_doc_nurse,manage_notice,manage_room,manage_compliant,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co__profile);

        manage_patient=findViewById(R.id.manage_patient);
        manage_appointment=findViewById(R.id.manage_appointment);
        manage_doc_nurse=findViewById(R.id.manage_doc_nurse);
        manage_notice=findViewById(R.id.manage_notice);
        manage_room=findViewById(R.id.manage_room);
        manage_compliant=findViewById(R.id.manage_compliant);
        name=findViewById(R.id.app_name);
        String username= (String) getIntent().getExtras().get("Name");
        name.setText("Welcome Back, Komal");

        manage_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Co_Profile.this,Co_manage_Patient.class);
                startActivity(i);
            }
        });

        manage_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Co_Profile.this,Co_manage_appointment.class);
                startActivity(i);
            }
        });

        manage_doc_nurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Co_Profile.this,co_manage_doc_nurse.class);
                startActivity(i);

            }

        });

        manage_compliant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(Co_Profile.this,Co_manage_complaint.class);
                startActivity(i);

            }

        });




    }
}