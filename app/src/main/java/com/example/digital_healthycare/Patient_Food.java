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

public class Patient_Food extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__food);
        dbHelper=new DBHelper(this);
        listView=findViewById(R.id.listview);
        String username = getIntent().getExtras().getString("Name");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent=new Intent(Patient_Food.this,Patient_Food_detail.class);
                intent.putExtra("Username",username);
                intent.putExtra("Name",selectedItem);
                startActivity(intent);
            }
        });
        ArrayList<String> FoodList=new ArrayList<>();
        Cursor data=dbHelper.getfood();
        if(data.getCount()==0){
            Toast.makeText(Patient_Food.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                FoodList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,FoodList);
                listView.setAdapter(listAdapter);
            }

        }
    }
}