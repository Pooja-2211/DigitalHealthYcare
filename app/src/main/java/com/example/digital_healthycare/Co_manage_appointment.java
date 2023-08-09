package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Co_manage_appointment extends AppCompatActivity {
    ListView listView;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_manage_appointment);
        listView=findViewById(R.id.listview);
        dbHelper=new DBHelper(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent=new Intent(Co_manage_appointment.this,Co_appointment_detail.class);
                intent.putExtra("Name",selectedItem);
                startActivity(intent);
            }
        });
        ArrayList<String> appointmentList=new ArrayList<>();
        Cursor data=dbHelper.listAppointment();
        if(data.getCount()==0){
            Toast.makeText(Co_manage_appointment.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                appointmentList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,appointmentList);
                listView.setAdapter(listAdapter);
            }

        }

    }}
