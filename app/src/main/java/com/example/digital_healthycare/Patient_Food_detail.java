package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Patient_Food_detail extends AppCompatActivity {
    TextView food_name,food_price;
    Button order_food;
    DBHelper dbHelper;
    String status="Pending";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__food_detail);
        String data = getIntent().getExtras().getString("Name");
        String username = getIntent().getExtras().getString("Username");
        food_name=findViewById(R.id.food_name);
        food_price=findViewById(R.id.food_price);
        order_food=findViewById(R.id.order_food);
        dbHelper=new DBHelper(this);
        showdata(data);


        order_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted=dbHelper.insertFoodOrder(data,username,status);
                if(isinserted==true){
                    Toast.makeText(Patient_Food_detail.this,"Order Placed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Patient_Food_detail.this,"Order Unsuccessful",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private void showdata(String data) {
        Cursor cursor=dbHelper.showFood(data);
        while(cursor.moveToNext()){
            food_name.setText(cursor.getString(1));
            food_price.setText(cursor.getString(2));
        }
    }
}