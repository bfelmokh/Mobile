package com.example.hello_sql_lite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Déclaration d'une base
        // si on modifie la version ==> appel implicite à onUpgrade
        MyHelper helper = new MyHelper(MainActivity.this,"base.db",null,1);

        // Permet d'ouvrir la base si elle existe, sinon elle crée le fichier et fait l'appel implicit pour l'onCreate afin de crée la base.
        SQLiteDatabase db = helper.getWritableDatabase();

        // Prepare insert
        ContentValues v = new ContentValues();
        v.put(MyHelper.col_long,"1.12345");
        v.put(MyHelper.col_lat,"6.54321");
        // Insert
        db.insert(MyHelper.table_pos,null,v);

        // Selection depuis la base
        //db = helper.getReadableDatabase();
        Cursor cr = db.query(MyHelper.table_pos,new String[]{MyHelper.col_id,MyHelper.col_long,MyHelper.col_lat},null,null,null,null,null);
        ListView lv = findViewById(R.id.lv);
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

        ArrayAdapter ad = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(ad);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ajouter une position ?", Snackbar.LENGTH_LONG)
                        .setAction("Ajout", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(MainActivity.this,Ajout.class);
                                startActivity(i);
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
