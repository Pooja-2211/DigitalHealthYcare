package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Co_user_detail extends AppCompatActivity {
    TextView patient_name,patient_email,patient_mobile,patient_dob,patient_date_Entry,patient_room;
    DBHelper dbHelper;
    Button update,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_user_detail);
        patient_name=findViewById(R.id.patient_name);
        patient_email=findViewById(R.id.patient_email);
        patient_mobile=findViewById(R.id.patient_mobile);
        patient_dob=findViewById(R.id.patient_dob);
        patient_date_Entry=findViewById(R.id.patient_date_Entry);
        patient_room=findViewById(R.id.patient_room);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        dbHelper=new DBHelper(this);
        String data = getIntent().getExtras().getString("Name");
        patient_name.setText(data);
        showdata(data);
        deletedata(data);
        updatedata(data);
    }

    private void updatedata(String data) {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Co_user_detail.this,Co_update_user.class);
                i.putExtra("Name",data);
                i.putExtra("Email",patient_email.getText().toString());
                i.putExtra("Mobile",patient_mobile.getText().toString());
                i.putExtra("DOB",patient_dob.getText().toString());
                i.putExtra("Date_Of_Entry",patient_date_Entry.getText().toString());
                i.putExtra("Room",patient_room.getText().toString());
                startActivity(i);

            }
        });
    }

    private void deletedata(String data) {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deletePatient(data);
                Toast.makeText(Co_user_detail.this,"User Removed",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Co_user_detail.this,Co_manage_Patient.class);
                startActivity(i);

            }
        });
    }

    private void showdata(String data) {
        Cursor cursor=dbHelper.showPatient(data);
        while(cursor.moveToNext()){
            patient_email.setText(cursor.getString(2));
            patient_mobile.setText(cursor.getString(4));
            patient_dob.setText(cursor.getString(5));
            patient_date_Entry.setText(cursor.getString(6));
            patient_room.setText(cursor.getString(7));

        }

    }
}