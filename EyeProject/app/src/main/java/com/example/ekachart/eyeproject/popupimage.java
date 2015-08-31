package com.example.ekachart.eyeproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Ekachart on 31/8/2558.
 */
public class popupimage extends Activity {
    private String rcvnum;
    private ImageView extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagebodsee);
        extra = (ImageView)findViewById(R.id.extraimage);
        rcvnum = getIntent().getStringExtra("num");
        extra.setImageResource(getResourceByFilename(getApplicationContext(), "bodsee_image"+rcvnum));
    }

    public static int getResourceByFilename(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "drawable", context.getPackageName());
    }
}
