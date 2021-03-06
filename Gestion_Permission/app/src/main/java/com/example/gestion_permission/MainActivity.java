package com.example.gestion_permission;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    ListView main_lv;
    static ArrayList<Autorisation> data = new ArrayList<Autorisation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        main_lv = findViewById(R.id.main_lv);
        data.add(new Autorisation("GPS",true));
        data.add(new Autorisation("Internet",false));
        data.add(new Autorisation("SDCard",true));
        //********* 1er type ****** Context / Affichage d'item / donnée
        //ArrayAdapter ad = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);
        //main_lv.setAdapter(ad);
        //*********

        //********* 2eme type ******** Context / data
        main_lv_adapter ad = new main_lv_adapter(MainActivity.this,data);
        main_lv.setAdapter(ad);
        //*********

        //********* ItemListener de listview
        main_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Builder alert = new Builder(MainActivity.this);
                alert.setTitle("Edition");
                LinearLayout ll;
                LayoutInflater v = LayoutInflater.from(MainActivity.this);
                // view.xml from R.layout,null
                ll = (LinearLayout) v.inflate(R.layout.view,null);
                TextView item_tv = ll.findViewById(R.id.item_tv);
                Switch item_sw = ll.findViewById(R.id.item_sw);
                item_tv.setText(data.get(position).getNom());
                item_sw.setChecked(data.get(position).isEtat());
                alert.setView(item_tv);
                alert.show();
            }
        });

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
                Intent i = new Intent(MainActivity.this,Affichage.class);
                startActivity(i);
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
