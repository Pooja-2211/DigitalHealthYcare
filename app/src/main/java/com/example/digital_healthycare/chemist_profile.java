package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class chemist_profile extends AppCompatActivity {
    EditText name, price;
    Button insert, update, delete, view, order;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemist_profile);
        name = findViewById(R.id.namem);
        price = findViewById(R.id.pricem);
        insert = findViewById(R.id.btnInsertm);
        update = findViewById(R.id.btnUpdatem);
        delete = findViewById(R.id.btnDeletem);
        view = findViewById(R.id.btnViewm);
        order= findViewById(R.id.btnOrderm);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String priceTXT = price.getText().toString();

                Boolean checkinsertdata = DB.insertmed(nameTXT, priceTXT);
                if(checkinsertdata==true)
                    Toast.makeText(chemist_profile.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(chemist_profile.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String priceTXT= price.getText().toString();

                Boolean checkupdatedata = DB.updatemed(nameTXT, priceTXT);
                if(checkupdatedata==true)
                    Toast.makeText(chemist_profile.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(chemist_profile.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletemed(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(chemist_profile.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(chemist_profile.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getmed();
                if(res.getCount()==0){
                    Toast.makeText(chemist_profile.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Price :"+res.getInt(2)+"\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(chemist_profile.this);
                builder.setCancelable(true);
                builder.setTitle("Product Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }
}