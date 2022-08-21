package com.example.assign_2_bscs_19011519_006;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserData";

    public DBHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table UserDetails (StudentName TEXT PRIMARY KEY, FatherName TEXT," +
                " RegistrationNo TEXT, ResearchTopic1 TEXT," +
                " Summary1 TEXT, SupervisorSignature1 TEXT, ResearchTopic2 TEXT," +
                " Summary2 TEXT, SupervisorSignature2 TEXT, ResearchTopic3 TEXT," +
                " Summary3 TEXT, SupervisorSignature3 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop TABLE if exists UserDetails");
    }

    public boolean insertUserData(String Sname, String Fname, String RegNo, String Synop1,
                                  String summ1, String sign1, String synop2, String summ2,
                                  String sign2, String synop3, String summ3, String sign3){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("StudentName", Sname);
        contentValues.put("FatherName", Fname);
        contentValues.put("RegistrationNo", RegNo);
        contentValues.put("ResearchTopic1", Synop1);
        contentValues.put("Summary1", summ1);
        contentValues.put("SupervisorSignature1", sign1);
        contentValues.put("ResearchTopic2", synop2);
        contentValues.put("Summary2", summ2);
        contentValues.put("SupervisorSignature2", sign2);
        contentValues.put("ResearchTopic3", synop3);
        contentValues.put("Summary3", summ3);
        contentValues.put("SupervisorSignature3", sign3);
        long result = MyDB.insert("UserDetails", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updateUserData(String Sname, String Fname, String RegNo, String Synop1,
                                  String summ1, String sign1, String synop2, String summ2,
                                  String sign2, String synop3, String summ3, String sign3){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("FatherName", Fname);
        contentValues.put("RegistrationNo", RegNo);
        contentValues.put("ResearchTopic1", Synop1);
        contentValues.put("Summary1", summ1);
        contentValues.put("SupervisorSignature1", sign1);
        contentValues.put("ResearchTopic2", synop2);
        contentValues.put("Summary2", summ2);
        contentValues.put("SupervisorSignature2", sign2);
        contentValues.put("ResearchTopic3", synop3);
        contentValues.put("Summary3", summ3);
        contentValues.put("SupervisorSignature3", sign3);
        Cursor cursor = MyDB.rawQuery("Select * from UserDetails where StudentName = ?", new String[] {Sname});

        if (cursor.getCount() > 0) {
            long result = MyDB.update("UserDetails", contentValues, "StudentName=?", new String[]{Sname});
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }

    public boolean deleteUserData(String Sname){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from UserDetails where StudentName = ?", new String[] {Sname});

        if (cursor.getCount() > 0) {
            long result = MyDB.delete("UserDetails", "StudentName=?", new String[]{Sname});
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }


    public Cursor viewUserData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from UserDetails", null);
        return cursor;
    }
}
