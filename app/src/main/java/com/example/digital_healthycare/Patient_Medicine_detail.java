package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Patient_Medicine_detail extends AppCompatActivity {
    TextView Medi_name,Medi_price;
    Button order_medi;
    DBHelper dbHelper;
    String status="Pending";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__medicine_detail);
        String data = getIntent().getExtras().getString("Item_Name");
        String username=getIntent().getExtras().getString("Username");
        dbHelper=new DBHelper(this);
        Medi_name=findViewById(R.id.Medi_name);
        Medi_price=findViewById(R.id.Medi_price);
        order_medi=findViewById(R.id.order_medi);
        showData(data);
        order_medi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted=dbHelper.insertMedOrder(data,username,status);
                if(isinserted==true){
                    Toast.makeText(Patient_Medicine_detail.this,"Order Placed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Patient_Medicine_detail.this, "Order Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showData(String data) {
        Cursor cursor=dbHelper.showMedi(data);
        while(cursor.moveToNext()){
            Medi_name.setText(cursor.getString(1));
            Medi_price.setText(cursor.getInt(2));
        }
    }
}