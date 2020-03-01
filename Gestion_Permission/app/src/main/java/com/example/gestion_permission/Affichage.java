package com.example.gestion_permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Bundle;

public class Affichage extends AppCompatActivity {
    private RecyclerView aff_rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        aff_rv = (RecyclerView) findViewById(R.id.aff_rv);
        Affiche_rv_adapter ad = new Affiche_rv_adapter(Affichage.this,MainActivity.data);
        aff_rv.setAdapter(ad);
        aff_rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //Gestion de la réponse de la permission
        if (requestCode==1) {
            if (grantResults[0]== PackageManager.PERMISSION_GRANTED){
                MainActivity.data.get(0).setEtat(true);
            }else{
                //aff_rv..invalidateItemDecorations();
                MainActivity.data.get(0).setEtat(false);
            }
        }
    }
}
