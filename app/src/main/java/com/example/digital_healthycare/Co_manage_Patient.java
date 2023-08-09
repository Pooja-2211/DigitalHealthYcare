package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Co_manage_Patient extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listview;
    FloatingActionButton adduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_manage__patient);
        listview=findViewById(R.id.listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent=new Intent(Co_manage_Patient.this,Co_user_detail.class);
                intent.putExtra("Name",selectedItem);
                startActivity(intent);
            }
        });
        adduser=(FloatingActionButton) findViewById(R.id.adduser);
        dbHelper=new DBHelper(this);

        ArrayList<String> PatientList=new ArrayList<>();
        Cursor data=dbHelper.listPatients();
        if(data.getCount()==0){
            Toast.makeText(Co_manage_Patient.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                PatientList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,PatientList);
                listview.setAdapter(listAdapter);
            }
        }

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Co_manage_Patient.this,co_AddUser.class);
                startActivity(i);
            }
        });

    }


}