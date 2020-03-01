package com.example.gestion_permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class Affiche_rv_adapter extends RecyclerView.Adapter<Affiche_rv_adapter.MyViewHolder> {

    Context c;
    ArrayList<Autorisation> data;

    public Affiche_rv_adapter(Context c, ArrayList<Autorisation> data) {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout ll;
        LayoutInflater li = LayoutInflater.from(c);
        ll = (LinearLayout) li.inflate(R.layout.view,null);
        return new MyViewHolder(ll);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.item_tv.setText(data.get(position).getNom());
        holder.item_sw.setChecked(data.get(position).isEtat());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends ViewHolder {
        TextView item_tv;
        Switch item_sw;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tv = itemView.findViewById(R.id.item_tv);
            item_sw = itemView.findViewById(R.id.item_sw);
            item_sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        // récupération indice de l'element selectionnée
                        int indice = getAdapterPosition();
                        Toast.makeText(c,"La permission activée est: "+data.get(indice).getNom(),Toast.LENGTH_SHORT).show();
                        if (data.get(indice).getNom().contains("GPS")){
                            ActivityCompat.requestPermissions((Activity) c,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1);
                        }
                    }
                }
            });
        }
    }
}
