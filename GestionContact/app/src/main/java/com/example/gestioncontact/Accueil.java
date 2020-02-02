package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity implements View.OnClickListener {
    public static ArrayList<Contact> data = new ArrayList<Contact>();
    TextView tuser;
    Button btnaff_acc,btnaj_acc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        tuser=(TextView)findViewById(R.id.tuser);
        Intent x = getIntent();
        Bundle b = x.getExtras();
        tuser.setText(b.getString("user"));
        btnaff_acc= (Button) findViewById(R.id.btnaff_acc);
        btnaj_acc= (Button) findViewById(R.id.btnaj_acc);

        btnaff_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Accueil.this,Affiche.class);
                startActivity(i);
            }
        });
        btnaj_acc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Accueil.this,Ajout.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
