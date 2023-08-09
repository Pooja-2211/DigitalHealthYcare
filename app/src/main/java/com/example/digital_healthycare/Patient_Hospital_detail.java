package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Patient_Hospital_detail extends AppCompatActivity {
    Button book;
    DBHelper dbHelper;
    TextView hosname,hosaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__hospital_detail);
        String data=getIntent().getExtras().getString("Name");
        book=findViewById(R.id.book);
        hosname=findViewById(R.id.name);
        hosaddress=findViewById(R.id.address);
        dbHelper=new DBHelper(this);
        showdata(data);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Patient_Hospital_detail.this,Appointment.class);
                startActivity(i);
            }
        });


    }

    private void showdata(String data) {
        Cursor cursor = dbHelper.showHospital(data);
        while (cursor.moveToNext()) {
            hosname.setText(cursor.getString(1));
            hosaddress.setText(cursor.getString(2));
        }
    }
}