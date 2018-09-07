package com.example.marianaperez.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class displayChange extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_change);
        TextView change500 = findViewById(R.id.change500);
        TextView change200 = findViewById(R.id.change200);
        TextView change100 = findViewById(R.id.change100);
        TextView change50 = findViewById(R.id.change50);
        TextView change20 = findViewById(R.id.change20);
        TextView change10 = findViewById(R.id.change10);
        TextView change5 = findViewById(R.id.change5);
        TextView change1 = findViewById(R.id.change1);
        TextView change05 = findViewById(R.id.change05);

        if(Global.change500 != 0) {
            change500.setText("500: " + Global.change500);
        }
        if(Global.change1 != 0) {
            change1.setText("1: " + Global.change1);
        }
        if(Global.change50 != 0) {
            change50.setText("50: " + Global.change50);
        }
        if(Global.change200 != 0) {
            change200.setText("200: " + Global.change200);
        }
        if(Global.change100 != 0) {
            change100.setText("100: " + Global.change100);
        }
        if(Global.change20 != 0) {
            change20.setText("20: " + Global.change20);
        }
        if(Global.change10 != 0) {
            change500.setText("10: " + Global.change10);
        }
        if(Global.change5 != 0) {
            change5.setText("5: " + Global.change5);
        }
        if(Global.change05 != 0) {
            change05.setText("0.5: " + Global.change05);
        }

    }
}
