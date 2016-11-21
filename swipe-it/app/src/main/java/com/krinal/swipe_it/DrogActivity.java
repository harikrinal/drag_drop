package com.krinal.swipe_it;

/**
 * Created by santhosh on 21/11/16.
 */

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrogActivity extends Activity {

    Button drag;
    LinearLayout drop;
    TextView text,sucess;
    int total , failure = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drog_activity);
        drag = (Button)findViewById(R.id.one);
        drop = (LinearLayout)findViewById(R.id.bottomlinear);
        text = (TextView)findViewById(R.id.Total);
        sucess = (TextView)findViewById(R.id.Sucess);

        drop.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                // TODO Auto-generated method stub
                final int action = event.getAction();
                switch(action) {

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DROP:{
                        failure = failure+1;
                        return(true);
                    }

                    case DragEvent.ACTION_DRAG_ENDED:{
                        total = total +1;
                        int suc = total - failure;
                        sucess.setText("Sucessful Drops :"+suc);
                        text.setText("Total Drops: "+total);
                        return(true);

                    }

                    default:
                        break;
                }
                return true;
            }});
        drop.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("haudfgkj","sdftgdsatg");
                return false;
            }
        });
        drag.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                // TODO Auto-generated method stub
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(drag);
                v.startDrag(data, shadow, null, 0);
                return false;
            }
        });

    }

}