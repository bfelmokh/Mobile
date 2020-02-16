package com.example.gestionfichiers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btn_save,btn_load;
    EditText ed_file;
    String dir= Environment.getExternalStorageDirectory().getPath();
    //String dir= Environment.getDownloadCacheDirectory().getPath();
    File f = new File (dir,"Fichier.txt");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_load = findViewById(R.id.btn_load);
        btn_save = findViewById(R.id.btn_save);
        ed_file = findViewById(R.id.ed_file);

        btn_load.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE )== PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(v.getContext(), dir + lire(), Toast.LENGTH_LONG).show();
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                }
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE )== PackageManager.PERMISSION_GRANTED) {
                    ecrire(ed_file.getText().toString());
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });


    }
    void ecrire (String ligne){
        try {
            FileWriter fw = new FileWriter(f,true); // (file , append (True or false ))
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ligne+"\n");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String lire (){
        String ligne,lignes=null;
        FileReader fr = null;
            try {
                if (f.exists()) {
                    System.out.println("Existe");
                    fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    while((ligne = br.readLine())!=null){
                        lignes = lignes + ligne;
                    };
                    br.close();
                    fr.close();
                } else {
                    System.out.println("Doesn't existe");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return lignes;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==1){
            if ((grantResults.length>-1)&&(grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                    System.out.println("Permission accordé");
                    ecrire(ed_file.getText().toString());
            } else {
                Toast.makeText(this,"Permission non accordée",Toast.LENGTH_LONG).show();
                System.out.println("Permission non accordé");
            }
        }
    }
}
