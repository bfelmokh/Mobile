package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Déclaration des composants graphiques;
    private Button btnval_auth,btnquit_auth;
    private EditText ednom_auth,edmp_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Méthode qui met l'interface XML sur l'écran.

        // Récupération des composants :
        btnval_auth = (Button) findViewById(R.id.btnval_auth);
        btnquit_auth = (Button) findViewById(R.id.btnquit_auth);
        ednom_auth = (EditText) findViewById(R.id.ednom_auth);
        edmp_auth = (EditText) findViewById(R.id.edmp_auth);

        //Ecouteur
        btnval_auth.setOnClickListener(this);
        btnquit_auth.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // v est la source de l'evennement
        if (v==btnquit_auth){
            this.finish();
        }
        // ednom_auth.getText().toString().equals();
        if (v==btnval_auth){
            String nom = ednom_auth.getText().toString();
            String mp = edmp_auth.getText().toString();
            if (nom.equals("admin") && mp.equals("admin")) {
                Toast.makeText(this, "Bonjour Admin", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this,Accueil.class);
                i.putExtra("user",nom);
                startActivity(i);
                MainActivity.this.finish();
            }
            else {
                Toast.makeText(this, "Echec", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Started", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Stopped", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Destroyed", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
