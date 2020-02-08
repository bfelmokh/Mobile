package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Affiche extends AppCompatActivity implements View.OnClickListener {
    ListView lvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);
        lvc = findViewById(R.id.lv_contact);
        //ArrayAdapter ad = new ArrayAdapter(Affiche.this,android.R.layout.simple_list_item_1,Accueil.data);
        //lvc.setAdapter(ad);

        MonAdapter ad = new MonAdapter(Affiche.this, Accueil.data);
        lvc.setAdapter(ad);
    }


    @Override
    public void onClick(View v) {

    }
}
