package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class canteen_profile extends AppCompatActivity {
    EditText name, price;
    Button insert, update, delete, view, order;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_profile);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        order= findViewById(R.id.btnOrder);
        DB = new DBHelper(this);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(canteen_profile.this,canteen_manage_order.class);
                startActivity(i);

            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String priceTXT = price.getText().toString();

                Boolean checkinsertdata = DB.insertfood(nameTXT, priceTXT);
                if(checkinsertdata==true)
                    Toast.makeText(canteen_profile.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(canteen_profile.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String priceTXT= price.getText().toString();

                Boolean checkupdatedata = DB.updatefood(nameTXT, priceTXT);
                if(checkupdatedata==true)
                    Toast.makeText(canteen_profile.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(canteen_profile.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletefood(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(canteen_profile.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(canteen_profile.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getfood();
                if(res.getCount()==0){
                    Toast.makeText(canteen_profile.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Price :"+res.getInt(2)+"\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(canteen_profile.this);
                builder.setCancelable(true);
                builder.setTitle("Product Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }
}