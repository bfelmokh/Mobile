package com.example.gestion_permission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class main_lv_adapter extends BaseAdapter {

    Context c;
    ArrayList<Autorisation> al;

    public main_lv_adapter(Context c, ArrayList<Autorisation> al) {
        this.c = c;
        this.al = al;
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout ll;
        LayoutInflater li = LayoutInflater.from(c);
        // view.xml from R.layout,null
        ll = (LinearLayout) li.inflate(R.layout.view,null);
        TextView item_tv = ll.findViewById(R.id.item_tv);
        Switch item_sw = ll.findViewById(R.id.item_sw);
        item_tv.setText(al.get(position).getNom());
        item_sw.setChecked(al.get(position).isEtat());
        return ll;
    }
}
