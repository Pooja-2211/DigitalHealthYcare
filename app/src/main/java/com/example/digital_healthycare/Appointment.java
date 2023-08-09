package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Appointment extends AppCompatActivity {
    Button save;
    EditText name,phone,disease,doctor,datetime;
    DBHelper dbHelper;
    String status="Pending";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        save=findViewById(R.id.addingappointment);
        name=findViewById(R.id.app_name);
        phone=findViewById(R.id.app_mobile);
        disease=findViewById(R.id.app_disease);
        doctor=findViewById(R.id.app_doc_name);
        datetime=findViewById(R.id.app_datetime);
        dbHelper=new DBHelper(this);
        insertdata();




    }

    private void insertdata() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted=dbHelper.insertAppointment(name.getText().toString(),Integer.parseInt(phone.getText().toString()),doctor.getText().toString(),disease.getText().toString(),datetime.getText().toString(),status);
                if(isinserted==true){
                    Toast.makeText(Appointment.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Appointment.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}