package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Co_complaint_detail extends AppCompatActivity {
    DBHelper dbHelper;
    TextView Complaint_name,rate,title1,desc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_complaint_detail);
        String data = getIntent().getExtras().getString("Name");
        Complaint_name=findViewById(R.id.Complaint_name);
        Complaint_name.setText(data);
        rate=findViewById(R.id.rate);
        title1=findViewById(R.id.title1);
        desc1=findViewById(R.id.desc1);
        dbHelper=new DBHelper(this);
        showData(data);
    }

    private void showData(String data) {
        Cursor cursor=dbHelper.showCompliant(data);
        while(cursor.moveToNext()){
            rate.setText(cursor.getString(2));
            title1.setText(cursor.getString(3));
            desc1.setText(cursor.getString(4));

        }
    }
}