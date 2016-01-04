package com.example.lancer.poptiles;

/**
 * Created by lancer on 3/1/16.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class TilesPlayAct extends Activity {
    GridView numGrid;
    MyTimer mMyTimer;
    static final int[] numbers = new int[] {
           111,2,3,4,5,6,7,8,9,0};


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tilesplay);

        numGrid = (GridView)findViewById(R.id.gridtile);
        Adapter adapter = new Adapter(numbers,getApplicationContext());
        numGrid.setAdapter(adapter);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          //      android.R.layout.simple_list_item_1, numbers);
        //numGrid.setAdapter(adapter);
       // numGrid.addView(tv, 0, 0);


    }
}
