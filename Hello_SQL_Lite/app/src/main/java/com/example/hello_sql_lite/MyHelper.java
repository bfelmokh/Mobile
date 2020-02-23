package com.example.hello_sql_lite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {
    public static final String table_pos = "Position";
    public static final String col_id = "Identifiant";
    public static final String col_long = "Longitude";
    public static final String col_lat = "Latitude";
    String req="create table "+table_pos+" ( " +
            col_id + " integer primary key autoincrement, " +
            col_long + " Text not null , " +
            col_lat + " Text not null "
            + " ) ";

    public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+ table_pos);
        onCreate(db);
    }
}
