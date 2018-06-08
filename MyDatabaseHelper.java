package com.example.nathaniel.musicsqlite.Muisc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nathaniel on 2018/6/2.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    static String name="music.db";
    static int dbVersion=1;
    private SQLiteDatabase db;
    public MyDatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }
    public void onCreate(SQLiteDatabase db) {
        String sql="create table music(id integer primary key autoincrement,Song varchar(20),Singer varchar(20))";
        db.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

