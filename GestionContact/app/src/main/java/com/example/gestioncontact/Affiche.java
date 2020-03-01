package com.example.gestioncontact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Affiche extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {
    ListView lvc;
    int indice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);
        lvc = findViewById(R.id.lv_contact);
        //ArrayAdapter ad = new ArrayAdapter(Affiche.this,android.R.layout.simple_list_item_1,Accueil.data);
        //lvc.setAdapter(ad);

        MonAdapter ad = new MonAdapter(Affiche.this, Accueil.data);
        lvc.setAdapter(ad);

        lvc.setOnItemClickListener(Affiche.this);


        }


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            indice=position;
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Attention ...");
            alert.setMessage("Selectionner une action");
            alert.setPositiveButton("Supprimer",this);
            alert.setNegativeButton("Modifier",this);
            alert.setNeutralButton("Annuler",this);
            alert.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case DialogInterface.BUTTON_POSITIVE :
                System.out.println("dialog supprimer " + indice);
                Accueil.data.remove(indice);
                lvc.invalidateViews();
            break ;
            case DialogInterface.BUTTON_NEGATIVE: ;
                System.out.println("dialog modifier " + indice);
            break;
            case DialogInterface.BUTTON_NEUTRAL: ;
                System.out.println("dialog annuler " + indice);
            break;
        }
    }
}
