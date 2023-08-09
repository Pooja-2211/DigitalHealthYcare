package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Co_nurse_detail extends AppCompatActivity {
    TextView nurse_name,nurse_email,nurse_mobile,nurse_dob;
    Button delete;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_nurse_detail);
        nurse_name=findViewById(R.id.food_name_order);
        nurse_email=findViewById(R.id.food_price_order);
        nurse_mobile=findViewById(R.id.nurse_mobile);
        nurse_dob=findViewById(R.id.nurse_dob);
        delete=findViewById(R.id.Acc_food);
        dbHelper=new DBHelper(this);
        String data = getIntent().getExtras().getString("Name");
        nurse_name.setText(data);
        showdata(data);
        deletedata(data);
    }

    private void deletedata(String data) {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteNurse(data);
                Toast.makeText(Co_nurse_detail.this,"Nurse Removed",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Co_nurse_detail.this,Co_manage_nurse.class);
                startActivity(i);

            }
        });

    }

    private void showdata(String data) {
        Cursor cursor = dbHelper.showNurse(data);
        while (cursor.moveToNext()) {
            nurse_email.setText(cursor.getString(2));
            nurse_mobile.setText(cursor.getString(4));
            nurse_dob.setText(cursor.getString(5));
        }
    }
}