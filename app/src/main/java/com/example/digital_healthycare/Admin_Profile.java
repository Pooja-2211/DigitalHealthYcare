package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Admin_Profile extends AppCompatActivity {
    TextView welcome;
    Button managehospital;
    FloatingActionButton addhospital;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__profile);
        String name=getIntent().getExtras().getString("Name");
        welcome=findViewById(R.id.welcome_admin);
        welcome.setText("Welcome Back,"+name);
        dbHelper=new DBHelper(this);

        addhospital=findViewById(R.id.addhospital);
        managehospital=findViewById(R.id.managehospital);
        managehospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Admin_Profile.this,Admin_manage_hospital.class);
                startActivity(i);
            }
        });
        addhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Admin_Profile.this,Admin_addHospital.class);
                startActivity(i);
            }
        });
    }
}