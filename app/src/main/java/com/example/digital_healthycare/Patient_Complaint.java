package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class Patient_Complaint extends AppCompatActivity{
    DBHelper dbHelper;
    RatingBar ratingBar2;
    EditText Complaint_title,complaint_desc;
    float rateValue;
    Button send;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__complaint);
        ratingBar2=findViewById(R.id.ratingBar2);
        Complaint_title=findViewById(R.id.Complaint_title);
        complaint_desc=findViewById(R.id.complaint_desc);
        name = getIntent().getExtras().getString("Name");
        send=findViewById(R.id.send);
        dbHelper=new DBHelper(this);
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateValue=ratingBar2.getRating();

            }
        });
        if(Complaint_title.getText().equals("")){
            Toast.makeText(Patient_Complaint.this,"Enter Title",Toast.LENGTH_SHORT).show();
        }
        else{
            insertdata();
        }


    }

    private void insertdata() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = dbHelper.insertComplaint(name,String.valueOf(rateValue),Complaint_title.getText().toString(), complaint_desc.getText().toString());
                if (isInserted == true)
                    Toast.makeText(Patient_Complaint.this, "Complaint Registered", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Patient_Complaint.this, "Complaint Not Registered", Toast.LENGTH_SHORT).show();

            }
        });




    }


}