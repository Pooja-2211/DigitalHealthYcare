package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class co_AddUser extends AppCompatActivity {
    DBHelper dbHelper;
    Button save,view;
    EditText Name,email,password,mobile,dob,entrydate,room;
    int role=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co__add_user);
        Name=findViewById(R.id.Name);
        email=findViewById(R.id.phone);
        password=findViewById(R.id.app_disease);
        dob=findViewById(R.id.app_datetime);
        entrydate=findViewById(R.id.entrydate);
        save=findViewById(R.id.save);
        view=findViewById(R.id.view);
        mobile=findViewById(R.id.app_doctor);
        room=findViewById(R.id.room);

        dbHelper=new DBHelper(this);
        addUser();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(co_AddUser.this,Co_manage_Patient.class);
                startActivity(i);
            }
        });

    }

    private void addUser() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=dbHelper.insertPatientDetails(Name.getText().toString(),email.getText().toString(),password.getText().toString(),Integer.parseInt(mobile.getText().toString()),dob.getText().toString(),entrydate.getText().toString(),room.getText().toString());
                if(isInserted == true) {
                    Toast.makeText(co_AddUser.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    boolean islogin=dbHelper.insertLogin(Name.getText().toString(),password.getText().toString(),role);
                    if(islogin==true)
                        Toast.makeText(co_AddUser.this,"User entered in login table",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(co_AddUser.this,"User Not entered in login table",Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(co_AddUser.this,"Date Not Inserted",Toast.LENGTH_SHORT).show();


            }
        });
    }
}