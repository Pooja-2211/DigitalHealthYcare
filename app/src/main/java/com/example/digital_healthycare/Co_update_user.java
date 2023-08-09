package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Co_update_user extends AppCompatActivity {

    EditText Name,email,password,mobile,dob,entrydate,room;
    Button save,view;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_update_user);
        Name=findViewById(R.id.Name);
        email=findViewById(R.id.phone);
        password=findViewById(R.id.app_disease);
        mobile=findViewById(R.id.app_doctor);
        dob=findViewById(R.id.app_datetime);
        entrydate=findViewById(R.id.entrydate);
        room=findViewById(R.id.room);
        save=findViewById(R.id.save);
        view=findViewById(R.id.view);
        String name = getIntent().getExtras().getString("Name");
        String Email= getIntent().getExtras().getString("Email");
        String Mobile=getIntent().getExtras().getString("Mobile");
        String Dob=getIntent().getExtras().getString("DOB");
        String Date_of_entry=getIntent().getExtras().getString("Date_Of_Entry");
        String Room=getIntent().getExtras().getString("Room");
        Name.setText(name);
        email.setText(Email);
        mobile.setText(Mobile);
        dob.setText(Dob);
        entrydate.setText(Date_of_entry);
        room.setText(Room);

        dbHelper=new DBHelper(this);
        updatedata(name);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Co_update_user.this,Co_manage_Patient.class);
                startActivity(i);
            }
        });


    }

    private void updatedata(String data) {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupadated=dbHelper.updatePatientDetails(Name.getText().toString(),email.getText().toString(),password.getText().toString(),Integer.parseInt(mobile.getText().toString()),dob.getText().toString(),entrydate.getText().toString(),room.getText().toString());
                if(isupadated == true)
                    Toast.makeText(Co_update_user.this,"Data Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Co_update_user.this,"Date Not Updated",Toast.LENGTH_SHORT).show();
            }
        });



    }
}