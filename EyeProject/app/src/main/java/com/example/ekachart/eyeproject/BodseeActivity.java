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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ekachart on 28/12/2557.
 */
public class BodseeActivity extends Activity{
    private Button check,next,home;
    private Button[] input;
    private TextView inputAnsTv;
    private ImageButton delete;
    private String answer;
    private ImageView imageViewBodSee;
    private BodseeData bodseeData;
    int numpic;
    private ScrollView mainscrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodsee1);
        init();
        initButton();

    }

    private void init() {
        bodseeData = new BodseeData();
        imageViewBodSee = (ImageView) findViewById(R.id.bodseeIV);
        imageViewBodSee.setImageResource(bodseeData.getCurrentPicQuestion(getApplicationContext()));
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
        inputAnsTv = (TextView)findViewById(R.id.num);
        check = (Button)findViewById(R.id.check);
        home = (Button)findViewById(R.id.home);
        next = (Button)findViewById(R.id.next);
        delete = (ImageButton)findViewById(R.id.delete);
        numpic = bodseeData.getNumberQuestion();
        mainscrollview = (ScrollView) findViewById(R.id.main);
    }//end init

    private void initButton(){

        imageViewBodSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getApplicationContext(), popupimage.class);
                j.putExtra("num", Integer.toString(numpic));
                startActivity(j);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText("");
                mainscrollview.fullScroll(ScrollView.FOCUS_UP);
                nextQuestion();
                numpic = bodseeData.getNumberQuestion();
                //Toast.makeText(getApplicationContext(), Integer.toString(numpic),Toast.LENGTH_SHORT).show();
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
                int len = inputAnsTv.getText().length();
                if (len > 0)
                    inputAnsTv.setText(inputAnsTv.getText().toString().substring(0, len - 1));
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
                inputAnsTv.setText("");
                return false;
            }
        });

        input[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[0].getText());
            }
        });

        input[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[1].getText());
            }
        });

        input[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[2].getText());
            }
        });

        input[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[3].getText());
            }
        });

        input[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[4].getText());
            }
        });

        input[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[5].getText());
            }
        });

        input[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[6].getText());
            }
        });

        input[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[7].getText());
            }
        });

        input[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[8].getText());
            }
        });

        input[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAnsTv.setText(inputAnsTv.getText().toString() + input[9].getText());
            }
        });
    }//end button

    private void checkAns(){
        AlertDialog.Builder builder = new AlertDialog.Builder(BodseeActivity.this);
        builder.setTitle("ตรวจสอบ");
        if(inputAnsTv.getText().toString().equals( bodseeData.getAnsOfQuestion( bodseeData.getNumberQuestion() ) ))
            answer = "Yes";
        else
            answer = "No";
        builder.setMessage(answer);
        builder.setNeutralButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                imageViewBodSee.setImageResource(bodseeData.nextPicQuestion(getApplicationContext()));
            }
        });
        builder.create();
        builder.show();
        inputAnsTv.setText("");
    }//end checkans

    private void nextQuestion(){
        imageViewBodSee.setImageResource( bodseeData.nextPicQuestion(getApplicationContext()) );
    }

}//end class
