package com.example.lancer.poptiles;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StartAct extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button butt_act_start = (Button)findViewById(R.id.butt);
        butt_act_start.setText("Start PopTyl");
        butt_act_start.setOnClickListener(startList);
    }
    private OnClickListener startList = new OnClickListener() {
        public void onClick(View v) {
            Intent myIntent = new Intent(StartAct.this, TilesPlayAct.class);
            startActivity(myIntent);
        }
    };
}
