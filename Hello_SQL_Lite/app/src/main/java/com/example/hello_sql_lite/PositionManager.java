package com.example.hello_sql_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import java.util.ArrayList;

public class PositionManager {
    Context con;
    SQLiteDatabase db;

    public PositionManager(Context con) {
        this.con = con;
    }

    public void ouvrir(){
        // Déclaration d'une base
        // si on modifie la version ==> appel implicite à onUpgrade
        MyHelper helper = new MyHelper(con,"base.db",null,1);

        // Permet d'ouvrir la base si elle existe, sinon elle crée le fichier et fait l'appel implicit pour l'onCreate afin de crée la base.
        db = helper.getWritableDatabase();

    }
    public void inserer(String ch1,String ch2){
        // Prepare insert
        ContentValues v = new ContentValues();
        v.put(MyHelper.col_long,ch1);
        v.put(MyHelper.col_lat,ch2);
        // Insert
        db.insert(MyHelper.table_pos,null,v);
    }
    public ArrayList selectionnertout(){
        // Selection depuis la base
        //db = helper.getReadableDatabase();
        Cursor cr = db.query(MyHelper.table_pos,new String[]{MyHelper.col_id,MyHelper.col_long,MyHelper.col_lat},null,null,null,null,null);
        // Conversion d'un cursor à une arrayList Data
        ArrayList data = new ArrayList();
        cr.moveToFirst();
        int i1;
        String i2,i3;
        while (!cr.isAfterLast()){
            i1 = cr.getInt(0);
            i2 = cr.getString(1);
            i3 = cr.getString(2);
            data.add(i1+" "+i2+" "+i3);
            cr.moveToNext();
        }
        return data;
    }
}
