package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajout extends AppCompatActivity implements View.OnClickListener {
    Button btnaj_aj,btnquit_aj;
    EditText tnom,tprenom,tnumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        btnaj_aj=(Button) findViewById(R.id.btnaj_aj);
        btnquit_aj=(Button) findViewById(R.id.btnquit_aj);
        tnom = (EditText) findViewById(R.id.tnom);
        tprenom = (EditText) findViewById(R.id.tprenom);
        tnumero = (EditText) findViewById(R.id.tnumero);

        btnaj_aj.setOnClickListener(this);
        btnquit_aj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnquit_aj){
            this.finish();
        }
        // ednom_auth.getText().toString().equals();
        if (v==btnaj_aj){
            String nom = tnom.getText().toString();
            String prenom = tprenom.getText().toString();
            String numero = tnumero.getText().toString();
            Accueil.data.add(new Contact(nom,prenom,numero));
            Toast.makeText(this, "Added", Toast.LENGTH_LONG).show();
        }
    }
}
