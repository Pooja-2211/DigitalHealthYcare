package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Patient_Profile extends AppCompatActivity {
    Button complaint,food,medicine;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__profile);
        complaint=findViewById(R.id.complaint);
        name=(TextView) findViewById(R.id.welcome);
        food=findViewById(R.id.food);
        medicine=findViewById(R.id.medicine);
        String data = getIntent().getExtras().getString("Name");
        name.setText("Welcome Back, "+data);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Patient_Profile.this,Patient_Food.class);
                i.putExtra("Name",data);
                startActivity(i);
            }
        });

        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Patient_Profile.this,Patient_Medicine.class);
                i.putExtra("Name",data);
                startActivity(i);

            }
        });
        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Patient_Profile.this,Patient_Complaint.class);
                i.putExtra("Name",data);
                startActivity(i);

            }
        });
    }
}