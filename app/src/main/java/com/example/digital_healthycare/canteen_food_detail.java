package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class canteen_food_detail extends AppCompatActivity {
    TextView food_name_order,food_price_order,food_order_by;
    Button Acc_food,reject_food;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_food_detail);
        String data = getIntent().getExtras().getString("Name");
        food_name_order=findViewById(R.id.food_name_order);
        food_order_by=findViewById(R.id.food_order_by);
        food_name_order.setText(data);
        Acc_food=findViewById(R.id.Acc_food);
        reject_food=findViewById(R.id.reject_food);
        dbHelper=new DBHelper(this);
        showdata(data);
        Acc_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated=dbHelper.updateAccFood(food_order_by.getText().toString());
                if(isupdated==true){
                    Toast.makeText(canteen_food_detail.this,"Food Order Accepted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(canteen_food_detail.this,"Food Order Accepted Error ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        reject_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated=dbHelper.updateRejFood(food_order_by.getText().toString());
                if(isupdated==true){
                    Toast.makeText(canteen_food_detail.this,"Food Order Rejected",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(canteen_food_detail.this,"Food Order Reject Error ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void showdata(String data) {
        Cursor cursor=dbHelper.showFoodOrder(data);
        while(cursor.moveToNext()){
            food_order_by.setText(cursor.getString(2));
            }


    }
}