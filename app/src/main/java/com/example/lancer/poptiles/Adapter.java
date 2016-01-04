package com.example.lancer.poptiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by poonam on 05/01/16.
 */
public class Adapter extends BaseAdapter {
    private  LayoutInflater inflater;
    Context con;
    int[] m;

    public Adapter(Context c) {
        con = c;
    }

    public Adapter(int[] x , Context c) {
        m = x;
        con=c;
        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return m.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return m[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        TextView textview ;
        if(convertView ==  null){

            convertView=  inflater.inflate(R.layout.list_item,null);


        }
        textview = (TextView )convertView.findViewById(R.id.text1);

        textview.setText(m[position]+"");
        return convertView;
    }

}