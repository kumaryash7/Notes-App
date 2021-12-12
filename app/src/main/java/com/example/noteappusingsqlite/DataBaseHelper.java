package com.example.noteappusingsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

public class DataBaseHelper extends SQLiteOpenHelper {
    //Table Name
    public static  final String TABLE_NAME = "COUNTRIES";
    //Table Columns:
    public static final  String _ID = "id";
    public static final String  SUBJECT ="subject";
    public static final String DESC ="description";
    //Database Information

    static final String DB_NAME = "NOTES_APP.DB";

    //Database version:
    static final int DB_VERSION = 1;
    //Creating Table Query:
    private static final String CREATE_TABLE;

    static {
        CREATE_TABLE = "create table " +
                TABLE_NAME + "(" + _ID + "INTEGER PRIMARY KEY AUTOINCREMENT , " + SUBJECT + "TEXT NOT NULL " + DESC + " TEXT );";
    }

    //CONSTRUCTOR FOR DATABASE HELPER
    public DataBaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
   onCreate(db);
    }
}
