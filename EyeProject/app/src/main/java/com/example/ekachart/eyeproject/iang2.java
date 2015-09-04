package com.example.ekachart.eyeproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Ekachart on 3/9/2558.
 */
public class iang2 extends Activity {
    private LinearLayout click;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iangtest);


        final Toast mytoast = Toast.makeText(getApplicationContext(),"กดที่รูปเมื่อทดสอบเสร็จแล้ว", Toast.LENGTH_SHORT);
        mytoast.setGravity(Gravity.RELATIVE_LAYOUT_DIRECTION, 0, 0);
        mytoast.show();

        click = (LinearLayout)findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), iang3.class);
                mytoast.cancel();
                startActivity(i);
            }
        });
    }
}
