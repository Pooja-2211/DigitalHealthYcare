package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Doctor_main extends AppCompatActivity {
    Button viewapp, viewpatient, viewprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);

        viewapp = findViewById(R.id.btnviewappont);
        viewpatient = findViewById(R.id.btnviewpatiet);
        viewprofile = findViewById(R.id.btnmyprofile);


        viewapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Doctor_main.this,Co_manage_appointment.class);
                startActivity(i);
            }
        });
        viewpatient.setOnClickListener(new View.OnClickListener(){
            @Override
              public void onClick(View v) {
            Intent i= new Intent(Doctor_main.this,doctor_manage_Patient.class);
            startActivity(i);
        }
         });

        viewprofile.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
            Intent i= new Intent(Doctor_main.this,Co_doc_detail.class);
            startActivity(i);
        }
    });
    };
}