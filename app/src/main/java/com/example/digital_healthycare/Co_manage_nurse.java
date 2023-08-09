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

public class Co_manage_nurse extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_manage_nurse);
        listview=findViewById(R.id.listview);
        dbHelper=new DBHelper(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent=new Intent(Co_manage_nurse.this,Co_nurse_detail.class);
                intent.putExtra("Name",selectedItem);
                startActivity(intent);
            }
        });
        ArrayList<String> NurseList=new ArrayList<>();
        Cursor data=dbHelper.listNurse();
        if(data.getCount()==0){
            Toast.makeText(Co_manage_nurse.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                NurseList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,NurseList);
                listview.setAdapter(listAdapter);
            }
        }
    }
}