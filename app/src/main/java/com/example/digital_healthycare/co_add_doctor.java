package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class co_add_doctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    DBHelper dbHelper;
    Spinner spinner;
    int role;
    EditText Name,email,password,mobile,dob,specialist;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_add_doctor);
        dbHelper=new DBHelper(this);
        spinner=findViewById(R.id.spinner);
        Name=findViewById(R.id.Name);
        email=findViewById(R.id.phone);
        password=findViewById(R.id.app_disease);
        mobile=findViewById(R.id.app_doctor);
        dob=findViewById(R.id.app_datetime);
        save=findViewById(R.id.save);
        specialist=findViewById(R.id.specialist);
        String[] items = new String[]{"Doctor","Nurse"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        insertData();
    }

    private void insertData() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(role==0){
                    boolean isinserted=dbHelper.insertDoctor(Name.getText().toString(),email.getText().toString(),password.getText().toString(),Integer.parseInt(mobile.getText().toString()),dob.getText().toString(),specialist.getText().toString());
                    if (isinserted==true)
                        Toast.makeText(co_add_doctor.this, "Doctor data Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(co_add_doctor.this, "Doctor data Not Inserted", Toast.LENGTH_SHORT).show();

                }
                else if(role==1){
                    boolean isinserted=dbHelper.insertNurse(Name.getText().toString(),email.getText().toString(),password.getText().toString(),Integer.parseInt(mobile.getText().toString()),dob.getText().toString());
                    if (isinserted==true)
                        Toast.makeText(co_add_doctor.this, "Nurse data Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(co_add_doctor.this, "Nurse data Not Inserted", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(co_add_doctor.this, "Select anyone", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                role=0;
                break;
            case 1:
               role=1;
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}