package com.example.lancer.poptiles;

/**
 * Created by lancer on 3/1/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;

import java.util.Random;

import static java.lang.Math.abs;

public class TilesPlayAct extends Activity {
    GridView numGrid;
    MyTimer mMyTimer;
    LayoutAnimationController lac;

    static final int[] numbers = new int[]{
            111, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    static final boolean[] iscellfilled = new boolean[9];
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
        for (i = 0; i < 9; i++) {
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
         runnable = new Runnable() {
            @Override
            public void run() {
                Random rn = new Random();
                int nxt = abs(rn.nextInt()) % 9;
                iscellfilled[nxt] = true;
                adapter.changeData(nxt);

                handler.postDelayed(this, 1000);
            }


        };


        int i;


    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,1000);
    }
}

