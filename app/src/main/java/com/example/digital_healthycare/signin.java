package com.example.digital_healthycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    EditText username,login_password;
    Button login,addmedicine,addfood;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        dbHelper=new DBHelper(this);
        username=findViewById(R.id.username);
        login_password=findViewById(R.id.login_password);
        login=findViewById(R.id.login);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("")||login_password.getText().equals("")){
                    Toast.makeText(signin.this,"Fill all fields",Toast.LENGTH_SHORT).show();
                }
                else if(username.getText().toString().equals("khushali@gmail.com")||login_password.getText().toString().equals("khushali")){
                    //Admin Login
                    Intent i=new Intent(signin.this,Admin_Profile.class);
                    String currentString = username.getText().toString();
                    String[] separated = currentString.split("@");
                    String name=separated[0];
                    i.putExtra("Name",name);
                    startActivity(i);
                }
                else if(username.getText().toString().equals("komal@gmail.com")||login_password.getText().toString().equals("komal")){
                    //Co-ordinator Login
                    Intent i=new Intent(signin.this,Co_Profile.class);
                    String currentString = username.getText().toString();
                    String[] separated = currentString.split("@");
                    String name=separated[0];
                    i.putExtra("Name",name);
                    startActivity(i);
                }
                else if(username.getText().toString().equals("canteen@gmail.com")||login_password.getText().toString().equals("canteen")){
                    Intent i=new Intent(signin.this,canteen_profile.class);
                    startActivity(i);

                }
                else if(username.getText().toString().equals("chemist@gmail.com")||login_password.getText().toString().equals("chemist")){
                    Intent i=new Intent(signin.this,chemist_profile.class);
                    startActivity(i);
                }
                else if(username.getText().toString().equals("doctor@gmail.com")||login_password.getText().toString().equals("doctor")){
                    //Doctor Login
                    Intent i=new Intent(signin.this,Doctor_main.class);
                    String currentString = username.getText().toString();
                    String[] separated = currentString.split("@");
                    String name=separated[0];
                    i.putExtra("Name",name);
                    startActivity(i);
                }
                else if(username.getText().toString().equals("nurse@gmail.com")||login_password.getText().toString().equals("nurse")){
                    //Nurse Login
                    Intent i=new Intent(signin.this,Nurse_main.class);
                    String currentString = username.getText().toString();
                    String[] separated = currentString.split("@");
                    String name=separated[0];
                    i.putExtra("Name",name);
                    startActivity(i);
                }

                else{
                    check_user_login();
                }
            }
        });
    }




    private void check_user_login() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=dbHelper.check_login(username.getText().toString(),login_password.getText().toString());
                if(isInserted == true){
                    Toast.makeText(signin.this,"Welcome",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(signin.this,App_mainactivity.class);
                    String currentString = username.getText().toString();
                    String[] separated = currentString.split("@");
                    String name=separated[0];
                    i.putExtra("Name",name);
                    startActivity(i);
                }
                else
                    Toast.makeText(signin.this,"invalid credentials",Toast.LENGTH_SHORT).show();
            }
        });
    }
}