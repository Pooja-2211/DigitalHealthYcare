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

public class Patient_Medicine extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__medicine);
        listView=findViewById(R.id.listview);
        dbHelper=new DBHelper(this);
        String username = getIntent().getExtras().getString("Name");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent=new Intent(Patient_Medicine.this,Patient_Medicine_detail.class);
                intent.putExtra("Username",username);
                intent.putExtra("Item_Name",selectedItem);
                startActivity(intent);
            }
        });
        ArrayList<String> MedicineList=new ArrayList<>();
        Cursor data=dbHelper.listMed();
        if(data.getCount()==0){
            Toast.makeText(Patient_Medicine.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                MedicineList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,MedicineList);
                listView.setAdapter(listAdapter);
            }

        }

    }}