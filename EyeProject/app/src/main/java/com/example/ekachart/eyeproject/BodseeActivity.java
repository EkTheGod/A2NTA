package com.example.ekachart.eyeproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ekachart on 28/12/2557.
 */
public class BodseeActivity extends Activity{
    private Button check,next,home;
    private Button[] input;
    private TextView test;
    private ImageButton delete;
    private String answer;
    private ImageView imageViewBodSee;
    private BodseeData bodseeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodsee1);
        init();
        initButton();
    }

    private void init() {
        input = new Button[10];
        input[0] = (Button)findViewById(R.id.b0);
        input[1] = (Button)findViewById(R.id.b1);
        input[2] = (Button)findViewById(R.id.b2);
        input[3] = (Button)findViewById(R.id.b3);
        input[4] = (Button)findViewById(R.id.b4);
        input[5] = (Button)findViewById(R.id.b5);
        input[6] = (Button)findViewById(R.id.b6);
        input[7] = (Button)findViewById(R.id.b7);
        input[8] = (Button)findViewById(R.id.b8);
        input[9] = (Button)findViewById(R.id.b9);
        test = (TextView)findViewById(R.id.num);
        check = (Button)findViewById(R.id.check);
        home = (Button)findViewById(R.id.home);
        next = (Button)findViewById(R.id.next);
        delete = (ImageButton)findViewById(R.id.delete);
        imageViewBodSee = (ImageView) findViewById(R.id.bodseeIV);
        bodseeData = new BodseeData();
    }//end init

    private void initButton(){

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bodseeData.nextQuestion();
                imageViewBodSee.setImageResource( bodseeData.getResourceByFilename(getApplicationContext(), "image" + bodseeData.getNumberQuestion() ) );
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),First.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = test.getText().length();
                if (len > 0)
                    test.setText(test.getText().toString().substring(0, len - 1));
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns();
            }
        });

        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                test.setText("");
                return false;
            }
        });

        input[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[0].getText());
            }
        });

        input[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[1].getText());
            }
        });

        input[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[2].getText());
            }
        });

        input[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[3].getText());
            }
        });

        input[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[4].getText());
            }
        });

        input[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[5].getText());
            }
        });

        input[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[6].getText());
            }
        });

        input[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[7].getText());
            }
        });

        input[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[8].getText());
            }
        });

        input[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(test.getText().toString() + input[9].getText());
            }
        });
    }//end button

    private void checkAns(){
        AlertDialog.Builder builder = new AlertDialog.Builder(BodseeActivity.this);
        builder.setTitle("ตรวจสอบ");
        if(test.getText().toString().equals( bodseeData.getAnsOfQuestion( bodseeData.getNumberQuestion() ) ))
            answer = "Yes";
        else
            answer = "No";
        bodseeData.nextQuestion();
        builder.setMessage(answer);
        builder.setNeutralButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                imageViewBodSee.setImageResource( bodseeData.getResourceByFilename(getApplicationContext(), "image" + bodseeData.getNumberQuestion() ) );
            }
        });
        builder.create();
        builder.show();
    }//end checkans

}//end class
