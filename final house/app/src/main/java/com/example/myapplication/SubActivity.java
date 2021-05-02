package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView tx1 = (TextView)findViewById(R.id.text1);
        Intent intent = getIntent();



         tx1 = (TextView)findViewById(R.id.text2);
        String check = intent.getStringExtra("check");
        tx1.setText(check);//전월세 출력


        tx1 = (TextView)findViewById(R.id.si);
        String address = getString(R.string.address);

        String si = intent.getStringExtra("si");
        String gu = intent.getStringExtra("gu");
        String dong = intent.getStringExtra("dong");

        tx1.setText(String.format(address,si,gu,dong));














        TextView tx2 = (TextView)findViewById(R.id.text3);
        String room1 = intent.getStringExtra("room1");
        tx2.setText(room1);

         tx2 = (TextView)findViewById(R.id.text4);
        String room2 = intent.getStringExtra("room2");
        tx2.setText(room2);

         tx2 = (TextView)findViewById(R.id.text5);
        String room3 = intent.getStringExtra("room3");
        tx2.setText(room3);

         tx2 = (TextView)findViewById(R.id.text6);
        String room4 = intent.getStringExtra("room4");
        tx2.setText(room4);

         tx2 = (TextView)findViewById(R.id.text7);
        String room5 = intent.getStringExtra("room5");
        tx2.setText(room5);

         tx2 = (TextView)findViewById(R.id.text8);
        String room6 = intent.getStringExtra("room6");
        tx2.setText(room6);

        tx2 = (TextView)findViewById(R.id.text9);
        String room7 = intent.getStringExtra("room7");
        tx2.setText(room7);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        String feature=getString(R.string.feature);

        int number1 = intent.getIntExtra(MainActivity.EXTRA_NUM1,0);
        int number2 = intent.getIntExtra(MainActivity.EXTRA_NUM2,0);
        int number3 = intent.getIntExtra(MainActivity.EXTRA_NUM3,0);


        textView1.setText(String.format(feature,number1,number2,number3));

        //입력한 값 출력

        TextView textView2 = findViewById(R.id.textView2);
        String apple = getString(R.string.apple);
        textView2.setText(apple);

    }
}
