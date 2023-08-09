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

public class Co_manage_Doc extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_manage__doc);
        dbHelper=new DBHelper(this);
        listview=findViewById(R.id.listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent=new Intent(Co_manage_Doc.this,Co_doc_detail.class);
                intent.putExtra("Name",selectedItem);
                startActivity(intent);
            }
        });
        ArrayList<String> DocList=new ArrayList<>();
        Cursor data=dbHelper.listDoc();
        if(data.getCount()==0){
            Toast.makeText(Co_manage_Doc.this,"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                DocList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,DocList);
                listview.setAdapter(listAdapter);
            }
        }
    }
}