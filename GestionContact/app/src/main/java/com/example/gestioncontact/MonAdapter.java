package com.example.gestioncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    Context c;
    ArrayList <Contact> d ;
    MonAdapter(Context c,ArrayList<Contact> d){
        this.c = c;
        this.d = d ;
    }

    @Override
    public int getCount() {
        return d.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout l;
        LayoutInflater inf = LayoutInflater.from(c);
        l = (LinearLayout) inf.inflate(R.layout.element,null);

        TextView t1 = l.findViewById(R.id.t1);
        t1.setText(d.get(position).getNom());
        TextView t2 = l.findViewById(R.id.t2);
        t2.setText(d.get(position).getPrenom());
        TextView t3 = l.findViewById(R.id.t3);
        t3.setText(d.get(position).getNumero());

        return l;
    }
}
