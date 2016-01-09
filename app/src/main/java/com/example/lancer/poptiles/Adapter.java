package com.example.lancer.poptiles;

import android.content.Context;
import android.os.Handler;
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
    boolean[] m;
    final Handler mHandler = new Handler();
    public Adapter(Context c) {
        con = c;
    }

    public Adapter(boolean[] x , Context c) {
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
        final TextView textview ;
        final int pos=position;
        if(convertView ==  null){

            convertView=  inflater.inflate(R.layout.list_item,null);


        }
        textview = (TextView )convertView.findViewById(R.id.text1);
        if(m[pos]==true) {
            textview.setText("1");
        }else {
            textview.setText("");
        }

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                textview.setText(m[pos] + "");

            }
        }, 5000);*/



       /* mHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/


        return convertView;
    }

    public void changeData(int nxt ) {

        m[nxt]=true;
        notifyDataSetChanged();
        notifyDataSetInvalidated();
    }
}