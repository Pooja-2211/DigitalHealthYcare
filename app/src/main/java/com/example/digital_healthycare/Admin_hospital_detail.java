package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_hospital_detail extends AppCompatActivity {
    DBHelper dbHelper;
    TextView hospital_name,hospital_address;
    Button delete_hos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hospital_detail);
        dbHelper=new DBHelper(this);
        hospital_name=findViewById(R.id.hospital_name);
        hospital_address=findViewById(R.id.hospital_address);
        delete_hos=findViewById(R.id.delete_hos);
        String data=getIntent().getExtras().getString("Name");
        detailhospital(data);
        deletehospital(data);

    }

    private void deletehospital(String data) {
        delete_hos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteHospital(data);
                Toast.makeText(Admin_hospital_detail.this,"Hospital Removed",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Admin_hospital_detail.this,Admin_manage_hospital.class);
                startActivity(i);
            }
        });


    }

    private void detailhospital(String data) {
        Cursor cursor = dbHelper.showHospital(data);
        while (cursor.moveToNext()) {
            hospital_name.setText(cursor.getString(1));
            hospital_address.setText(cursor.getString(2));
        }
    }
}