package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Co_doc_detail extends AppCompatActivity {
    DBHelper dbHelper;
    Button update, delete;
    TextView doc_name, doc_email, doc_mobile, doc_dob, doc_specialist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_doc_detail);
        dbHelper = new DBHelper(this);

        delete = findViewById(R.id.Acc_food);
        doc_name = findViewById(R.id.food_name_order);
        doc_email = findViewById(R.id.food_price_order);
        doc_mobile = findViewById(R.id.nurse_mobile);
        doc_dob = findViewById(R.id.nurse_dob);
        doc_specialist = findViewById(R.id.doc_specialist);
        String data = getIntent().getExtras().getString("Name");
        doc_name.setText(data);
        showdata(data);
        deletedata(data);


    }

    private void deletedata(String data) {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteDoc(data);
                Toast.makeText(Co_doc_detail.this,"Doctor Removed",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Co_doc_detail.this,Co_manage_Doc.class);
                startActivity(i);

            }
        });
    }

    public void showdata(String data) {
        Cursor cursor = dbHelper.showDoctor(data);
        while (cursor.moveToNext()) {
            doc_email.setText(cursor.getString(2));
            doc_mobile.setText(cursor.getString(4));
            doc_dob.setText(cursor.getString(5));
            doc_specialist.setText(cursor.getString(6));
        }
    }
}