package com.example.digital_healthycare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Nurse_main extends AppCompatActivity {

        Button viewpatient, emergency ;
        DBHelper DB;


        @SuppressLint("MissingSuperCall")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_nurse_main);


            viewpatient = findViewById(R.id.btnviewpatiet);


            DB = new DBHelper(this);


            viewpatient.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(Nurse_main.this,doctor_manage_Patient.class);
                    startActivity(i);
                }
            });


    }
}