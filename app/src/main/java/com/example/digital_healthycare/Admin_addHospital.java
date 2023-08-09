package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_addHospital extends AppCompatActivity {
    DBHelper dbHelper;
    Button addhospital;
    EditText hosname,hosaddress,hos_co_name,hos_co_pass;
    int role=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_hospital);
        dbHelper=new DBHelper(this);
        addhospital=findViewById(R.id.add_hos);
        hosname=findViewById(R.id.hos_name);
        hosaddress=findViewById(R.id.hos_address);
        hos_co_name=findViewById(R.id.hos_co_name);
        hos_co_pass=findViewById(R.id.hos_co_pass);
        add_hospital();
    }

    private void add_hospital() {
        addhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted=dbHelper.insertHospital(hosname.getText().toString(),hosaddress.getText().toString(),hos_co_name.getText().toString(),hos_co_pass.getText().toString());
                if(isinserted==true){
                    Toast.makeText(Admin_addHospital.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    boolean islogin=dbHelper.insertLogin(hos_co_name.getText().toString(),hos_co_pass.getText().toString(),role);
                    if(islogin==true){
                        Toast.makeText(Admin_addHospital.this, "Data Inserted in login", Toast.LENGTH_SHORT).show();}
                    else{
                        Toast.makeText(Admin_addHospital.this, "Data Not Inserted in login", Toast.LENGTH_SHORT).show();
                    }

                    Intent i=new Intent(Admin_addHospital.this,Admin_manage_hospital.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Admin_addHospital.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}