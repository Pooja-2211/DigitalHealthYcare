package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Co_appointment_detail extends AppCompatActivity {
    TextView name,mobile,disease,doctor,duration;
    Button accept,reject;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_appointment_detail);
        String data = getIntent().getExtras().getString("Name");
        name=findViewById(R.id.getname);
        name.setText(data);
        mobile=findViewById(R.id.mobile);
        disease=findViewById(R.id.disease);
        doctor=findViewById(R.id.doctor);
        duration=findViewById(R.id.duration);
        accept=findViewById(R.id.accept);
        reject=findViewById(R.id.reject);
        dbHelper=new DBHelper(this);
        showData(data);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  boolean isupdated=dbHelper.updateAccAppointment(name.getText().toString());
                  if(isupdated==true){
                      Toast.makeText(Co_appointment_detail.this,"Appointment Accepted",Toast.LENGTH_SHORT).show();
                  }
                  else{
                      Toast.makeText(Co_appointment_detail.this,"Appointment Accept ",Toast.LENGTH_SHORT).show();
                  }

            }
        });
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated=dbHelper.updateRejAppointment(name.getText().toString());
                if(isupdated==true){
                    Toast.makeText(Co_appointment_detail.this,"Appointment Rejected",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Co_appointment_detail.this,"Appointment Rejection Unsuccessfull",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void showData(String data) {
        Cursor cursor=dbHelper.showAppointment(data);
        while(cursor.moveToNext()){
            mobile.setText(cursor.getString(2));
            disease.setText(cursor.getString(3));
            doctor.setText(cursor.getString(4));
            duration.setText(cursor.getString(5));
        }
    }
}