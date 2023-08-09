package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class doctor_manage_Patient extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_manage__patient);
        listview=findViewById(R.id.listview);
        dbHelper=new DBHelper(this);
        ArrayList<String> PatientList=new ArrayList<>();
        Cursor data=dbHelper.listPatients();
        if(data.getCount()==0){
            Toast.makeText(doctor_manage_Patient.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                PatientList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,PatientList);
                listview.setAdapter(listAdapter);
            }
        }
    }
}