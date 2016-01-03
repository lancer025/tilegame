package com.example.lancer.poptiles;

/**
 * Created by lancer on 3/1/16.
 */
import android.os.CountDownTimer;
import android.widget.BaseAdapter;

public class MyTimer extends CountDownTimer {

    BaseAdapter mAdapter;

    public MyTimer(long millisInFuture, long countDownInterval, BaseAdapter adapter) {

        super( millisInFuture, countDownInterval );
        mAdapter = adapter;
    }

    @Override
    public void onFinish() {

        mAdapter.notifyDataSetChanged();
        this.start();
    }

    @Override
    public void onTick( long millisUntilFinished ) {

        // NO OP
    }

}