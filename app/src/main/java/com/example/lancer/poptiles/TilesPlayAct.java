package com.example.lancer.poptiles;

/**
 * Created by lancer on 3/1/16.
 */
import android.os.Bundle;
import android.app.Activity;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class TilesPlayAct extends Activity {
    GridView numGrid;
    MyTimer mMyTimer;
    static final String[] numbers = new String[] {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9" ,
            "10", "11", "12",
            "13", "14", "15"};


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tilesplay);

        numGrid = (GridView)findViewById(R.id.gridtile);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);
        numGrid.setAdapter(adapter);

    }
}
