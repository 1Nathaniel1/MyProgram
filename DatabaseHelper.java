package com.example.nathaniel.musicsqlite.User;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nathaniel on 2018/6/1.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name="user.db";
    static int dbVersion=1;
    public DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20))";
        db.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
