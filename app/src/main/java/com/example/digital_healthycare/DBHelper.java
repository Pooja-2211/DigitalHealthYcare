package com.example.digital_healthycare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.sql.SQLInput;
import java.util.BitSet;

public class DBHelper extends SQLiteOpenHelper {
    public static final String Database_Name="Trial1.db";
    public static final String Table_0="Login";
    public static final String Table_1="Appointment";
    public static final String Table2="Patient";
    public static final String Table_3="Doctor";
    public static final String Table_10="Nurse";
    public static final String Table_4="Complaint_Feedback";
    public static final String Table_5="Food";
    public static final String Table_6="Hospital";
    public static final String Table_7="medicine";
    public static final String Table_8="Food_Orders";
    public static final String Table_9="Medicine_Order";



    public DBHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table "+Table_0+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PASSWORD TEXT,ROLE INTEGER)");
        db.execSQL("create table "+Table_1+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE INTEGER,DISEASE TEXT,DOCTOR TEXT,DURATION TEXT,STATUS TEXT)");
        db.execSQL("create table "+Table2+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT,MOBILE INTEGER,DOB TEXT,DATE_OF_ENTRY TEXT,ROOM TEXT)");
        db.execSQL("create table "+Table_3+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT,MOBILE INTEGER,DOB TEXT,SPECIALIST TEXT)");
        db.execSQL("create table "+Table_4+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,SENDER_NAME TEXT,RATING TEXT,TITLE TEXT,DESCRIPTION TEXT)");
        db.execSQL("create table "+Table_5+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE INTEGER)");
        db.execSQL("create table "+Table_7+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE INTEGER)");
        db.execSQL("create table "+Table_6+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,HOSPITAL_NAME TEXT,HOSPITAL_ADDRESS TEXT,Co_Name TEXT,Password TEXT)");
        db.execSQL("create table "+Table_8+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Item TEXT,Order_BY TEXT,Status TEXT)");
        db.execSQL("create table "+Table_9+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Item TEXT,Order_BY TEXT,Status TEXT)");
        db.execSQL("create table "+Table_10+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT,MOBILE INTEGER,DOB TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_0);
        db.execSQL("DROP TABLE IF EXISTS "+Table_1);
        db.execSQL("DROP TABLE IF EXISTS "+Table2);
        db.execSQL("DROP TABLE IF EXISTS "+Table_3);
        db.execSQL("DROP TABLE IF EXISTS "+Table_4);
        db.execSQL("DROP TABLE IF EXISTS "+Table_5);
        db.execSQL("DROP TABLE IF EXISTS "+Table_6);
        db.execSQL("DROP TABLE IF EXISTS "+Table_7);
        db.execSQL("DROP TABLE IF EXISTS "+Table_8);
        db.execSQL("DROP TABLE IF EXISTS "+Table_9);

        onCreate(db);
    }

    boolean insertPatientDetails(String name, String email, String password, Integer mobile, String dob,String date_of_entry,String room){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        values.put("MOBILE",mobile);
        values.put("DOB",dob);
        values.put("DATE_OF_ENTRY",date_of_entry);
        values.put("ROOM",room);


        long result = db.insert(Table2,null ,values);
        if(result == -1)
            return false;
        else
            return true;

    }
    boolean insertDoctor(String name, String email, String password, int mobile, String dob, String specialist) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        values.put("MOBILE",mobile);
        values.put("DOB",dob);
        values.put("SPECIALIST",specialist);

        long result=db.insert(Table_3,null,values);
        if(result == -1)
            return false;
        else
            return true;
    }
    boolean insertNurse(String name, String email, String password, int mobile, String dob) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        values.put("MOBILE",mobile);
        values.put("DOB",dob);

        long result=db.insert(Table_10,null,values);
        if(result == -1)
            return false;
        else
            return true;
    }
    boolean insertFoodOrder(String item,String user,String status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Item",item);
        values.put("Order_BY",user);
        values.put("Status",status);

        long result=db.insert(Table_8,null,values);
        if(result==-1)
            return false;
        else
            return true;

    }
    boolean insertMedOrder(String item,String user,String status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Item",item);
        values.put("Order_BY",user);
        values.put("Status",status);

        long result=db.insert(Table_9,null,values);
        if(result==-1)
            return false;
        else
            return true;

    }
    boolean insertLogin(String name,String password,Integer role){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("PASSWORD",password);
        values.put("ROLE",role);

        long result=db.insert(Table_0,null,values);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    boolean insertAppointment(String name,Integer mobile,String doctor,String disease,String duration,String status ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("MOBILE",mobile);
        values.put("DOCTOR",doctor);
        values.put("DURATION",duration);
        values.put("DISEASE",disease);
        values.put("STATUS",status);
        long result=db.insertOrThrow(Table_1,null,values);
        if(result==-1)
            return false;
        else
            return true;

    }
    boolean insertHospital(String hosname,String hosaddress,String co_name,String co_password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("HOSPITAL_NAME",hosname);
        values.put("HOSPITAL_ADDRESS",hosaddress);
        values.put("Co_Name",co_name);
        values.put("Password",co_password);
        long result=db.insert(Table_6,null,values);
        if(result==-1)
            return false;
        else
            return true;
    }

    boolean insertComplaint(String sender,String rating,String title,String description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("SENDER_NAME",sender);
        values.put("RATING",rating);
        values.put("TITLE",title);
        values.put("DESCRIPTION",description);

        long result=db.insert(Table_4,null,values);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Boolean insertfood(String name, String price)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("price", price);
        long result=DB.insert(Table_5, null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updatefood(String name, String price) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("price", price);
        Cursor cursor = DB.rawQuery("Select * from food where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("food", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}

    public Boolean deletefood (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from food where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("food", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getfood()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from "+Table_5, null);
        return cursor;

    }

    public Boolean insertmed(String name, String price)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("price", price);
        long result=DB.insert("medicine", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updatemed(String name, String price) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("price", price);
        Cursor cursor = DB.rawQuery("Select * from medicine where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("medicine", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}

    public Boolean deletemed (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from medicine where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("medicine", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getmed ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from medicine", null);
        return cursor;

    }

    boolean updatePatientDetails(String name, String email, String password, Integer mobile, String dob,String date_of_entry,String room){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("EMAIL",email);
        contentValues.put("PASSWORD",password);
        contentValues.put("MOBILE",mobile);
        contentValues.put("DOB",dob);
        contentValues.put("DATE_OF_ENTRY",date_of_entry);
        contentValues.put("ROOM",room);
        Cursor cursor = db.rawQuery("Select * from Patient where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = db.update(Table2, contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }
    boolean updateAccAppointment(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+Table_1+" SET STATUS = 'Accepted' WHERE NAME = '"+name+"'");
        return true;
    }

    boolean updateRejAppointment(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+Table_1+" SET STATUS = 'Rejected' WHERE NAME = '"+name+"'");
        return true;
    }
    boolean updateAccFood(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+Table_8+" SET STATUS = 'Accepted' WHERE Order_BY = '"+name+"'");
        return true;
    }
    boolean updateRejFood(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+Table_8+" SET STATUS = 'Rejected' WHERE Order_BY = '"+name+"'");
        return true;
    }




    boolean insertFoodItems(String food_name,Integer Price,Integer Role ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",food_name);
        values.put("PRICE",Price);
        values.put("ROLE",Role);

        long result=db.insert(Table_5,null,values);
        if(result==-1)
            return false;
        else
            return true;
    }



    boolean insertDoctor_Nurse(String name, String email, String password, Integer mobile, String dob,String specialist,Integer role){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        values.put("MOBILE",mobile);
        values.put("DOB",dob);
        values.put("SPECIALIST",specialist);
        values.put("ROLE",role);


        long result = db.insert(Table_3,null ,values);
        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor listPatients(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table2,null);
        return data;
    }
    public Cursor listFoodOrder(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_8,null);
        return data;
    }
    public Cursor hospitallist(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_6,null);
        return data;
    }

    public Cursor SpinnerDoc(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_3,null);
        return data;
    }
    public Cursor listAppointment(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_1,null);
        return data;
    }

    public Cursor listComplaints(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_4,null);
        return data;
    }
    public Cursor listDoc(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_3,null);
        return data;
    }
    public Cursor listNurse(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_10,null);
        return data;
    }

    public Cursor listMed(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Table_7,null);
        return data;
    }




    public Cursor showPatient(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table2+" WHERE NAME ='"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }
    public Cursor showHospital(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_6+" WHERE HOSPITAL_NAME ='"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }

    public Cursor showFood(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_5+" WHERE NAME ='"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }

    public Cursor showMedi(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_5+" WHERE NAME ='"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }



    public Cursor showCompliant(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_4+" WHERE SENDER_NAME = '"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }
    public Cursor showAppointment(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_1+" WHERE NAME = '"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;

    }
    public Cursor showDoctor(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_3+" WHERE NAME = '"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }
    public Cursor showFoodOrder(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_8+" WHERE Item = '"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }

    public Cursor showNurse(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String select="SELECT * FROM "+Table_10+" WHERE NAME = '"+Name+"'";
        Cursor c=db.rawQuery(select,null);
        return c;
    }
    public void deletePatient(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String delete="DELETE FROM "+Table2+" WHERE NAME = '"+Name+"'";
        db.execSQL(delete);

    }
    public void deleteDoc(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String delete="DELETE FROM "+Table_3+" WHERE NAME = '"+Name+"'";
        db.execSQL(delete);
    }
    public void deleteNurse(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String delete="DELETE FROM "+Table_10+" WHERE NAME = '"+Name+"'";
        db.execSQL(delete);
    }


    public void deleteHospital(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        String delete="DELETE FROM "+Table_6+" WHERE HOSPITAL_NAME = '"+Name+"'";
        db.execSQL(delete);
    }

    public boolean check_login(String u_name, String u_pwd) {

        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM "+Table2+" WHERE EMAIL ='" + u_name + "' AND PASSWORD='" + u_pwd + "'";

        Cursor c = db.rawQuery(select, null);

        if (c.moveToFirst()) {
            return true;
        }

        if(c!=null) {
            c.close();
        }
        return false;

    }
    public Cursor getdata_doc ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Doctor", null);
        return cursor;

    }



}