package com.example.lancer.poptiles;

/**
 * Created by lancer on 3/1/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Random;

import static java.lang.Math.abs;

public class TilesPlayAct extends Activity {
    GridView numGrid;
    MyTimer mMyTimer;
    LayoutAnimationController lac;

    static final int[] numbers = new int[]{
            111, 2, 3, 4, 5, 6, 7, 8, 9, 0,4,5,6,87,9,9,3,4,671,34,6,7,3,2,9,214,45,6,7,8,};
    static final boolean[] iscellfilled = new boolean[35];
    int i;
    Adapter adapter;
    private Handler handler;
    private Runnable runnable;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tilesplay);
        handler = new Handler();
        lac = new LayoutAnimationController(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein), 0.5f); //0.5f == time between appearance of listview items.

        numGrid = (GridView) findViewById(R.id.gridtile);
        for (i = 0; i <35 ; i++) {
            iscellfilled[i] = false;
        }
        iscellfilled[0] = true;


        adapter = new Adapter(iscellfilled, getApplicationContext());
        numGrid.setAdapter(adapter);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //      android.R.layout.simple_list_item_1, numbers);
        //numGrid.setAdapter(adapter);
        // numGrid.addView(tv, 0, 0);
        // numGrid.setLayoutAnimation(lac);
        //numGrid.startLayoutAnimation();
        numGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                // Send intent to SingleViewActivity


            }
        });


     runnable = new Runnable() {
            @Override
            public void run() {
                Random rn = new Random();
                int nxt = abs(rn.nextInt()) % 35;
                iscellfilled[nxt] = true;
                adapter.changeData(nxt);

                handler.postDelayed(this, 200);
            }


        };


        int i;


    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,200);
    }
}

