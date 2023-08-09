package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class App_mainactivity extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listView;
    FloatingActionButton user_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_mainactivity);
        String name = getIntent().getExtras().getString("Name");
        dbHelper=new DBHelper(this);
        listView=findViewById(R.id.listview);
        user_profile=findViewById(R.id.floatingActionButton);
        user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(App_mainactivity.this,Patient_Profile.class);
                intent.putExtra("Name",name);
                startActivity(intent);

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent=new Intent(App_mainactivity.this,Patient_Hospital_detail.class);
                intent.putExtra("Name",selectedItem);
                startActivity(intent);
            }
        });
        ArrayList<String> hospital_list=new ArrayList<>();
        Cursor data=dbHelper.hospitallist();
        if(data.getCount()==0){
            Toast.makeText(App_mainactivity.this,"No data",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(App_mainactivity.this,signin.class);
            startActivity(intent);
        }
        else {
            while (data.moveToNext()){
                hospital_list.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,hospital_list);
                listView.setAdapter(listAdapter);
            }

        }
    }
}