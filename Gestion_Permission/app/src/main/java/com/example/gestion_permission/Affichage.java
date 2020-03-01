package com.example.gestion_permission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Affichage extends AppCompatActivity {
    private RecyclerView aff_rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        aff_rv = (RecyclerView) findViewById(R.id.aff_rv);
        Affiche_rv_adapter ad = new Affiche_rv_adapter(Affichage.this,MainActivity.data);
    }
}
