package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class co_manage_doc_nurse extends AppCompatActivity {
    Button manage_doctor,manage_nurse;
    FloatingActionButton add_doctor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_manage_doc_nurse);
        add_doctor=findViewById(R.id.floatingActionButton2);
        manage_doctor=findViewById(R.id.manage_doctor);
        manage_nurse=findViewById(R.id.manage_nurse);
        manage_nurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(co_manage_doc_nurse.this,Co_manage_nurse.class);
                startActivity(i);

            }
        });

        manage_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(co_manage_doc_nurse.this,Co_manage_Doc.class);
                startActivity(i);

            }
        });

        add_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(co_manage_doc_nurse.this,co_add_doctor.class);
                startActivity(i);
            }
        });





    }
}