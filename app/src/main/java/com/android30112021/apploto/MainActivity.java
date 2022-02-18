package com.android30112021.apploto;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mbuttonReset, mbuttonProGress;
    TextView mtextViewResult, mtextViewNumberRandom;
    String result = "";
    ScrollView mScrollview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrollview = findViewById(R.id.scrollView1);

        mbuttonProGress = findViewById(R.id.buttonProgress);
        mbuttonReset = findViewById(R.id.buttonReset);
        mtextViewNumberRandom = findViewById(R.id.textViewNumberRandom);
        mtextViewResult = findViewById(R.id.textViewResult);
        int size = 100;
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) {
            list.add(i);
        }



        mbuttonProGress.setOnClickListener(new View.OnClickListener() {
            boolean flag;
            @Override
            public void onClick(View view) {

                Random Rand = new Random();
                if(list.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Hết Số Rồi", Toast.LENGTH_SHORT).show();
                }
                else {
                    int index = Rand.nextInt(list.size());
                    result = result + (String.valueOf(list.get(index)) + " - ");
                    mtextViewNumberRandom.setText(String.valueOf(list.get(index)));
                    list.remove(index);
                    mtextViewResult.setText(result);
                    mScrollview.fullScroll(mScrollview.FOCUS_DOWN);

                    Log.d("BBB", "result" + result);
                }
            }
        });
        mbuttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                result ="";

                mtextViewResult.setText(result);
                mtextViewNumberRandom.setText(result);
                for(int i = 1; i <= size; i++) {
                    list.add(i);
                }


            }
        });



    }
}