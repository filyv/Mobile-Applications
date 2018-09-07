package com.example.marianaperez.exam1p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button rock=(Button)findViewById(R.id.rockp1);
        Button paper=(Button)findViewById(R.id.paperp1);
        Button scissors=(Button)findViewById(R.id.scissorsp1);
        Button reset=(Button)findViewById(R.id.reset);


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.p1choice = 1;
                getP2();
                getP2Text();
                int n = getWinner();
                setToast(n);
                setScore();
                System.out.println(Global.p2choice + "hewwo\n");
                System.out.println(Global.p1choice);
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.p1choice = 2;
                getP2();
                getP2Text();
                int n = getWinner();
                setToast(n);
                setScore();
                System.out.println(Global.p1choice);
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.p1choice = 3;
                getP2();
                getP2Text();
                int n = getWinner();
                setToast(n);
                setScore();
                System.out.println(Global.p1choice);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.p1wins = 0;
                Global.p2wins = 0;
                setScore();
            }
        });



    }

    public void getP2Text() {
        TextView p2 = findViewById(R.id.p2choice);
        if(Global.p2choice == 1) {
            p2.setText("The computer chooses rock");
        }
        if(Global.p2choice == 2) {
            p2.setText("The computer chooses paper");
        }
        if(Global.p2choice == 3) {
            p2.setText("The computer chooses scissors");
        }
    }

    public void getP2() {
        Random rand = new Random();
        int  n = rand.nextInt(3) + 1;
        /*        System.out.println(n + "hewwo");*/
        Global.p2choice = n;
    }

    public void setToast(int n) {
        Context ct = getApplicationContext();
        CharSequence text = "";
        if(n == 1) {
            text = "You won";
        }
        if(n == 2) {
            text = "The computer won";
        }
        if(n == 0) {
            text = "nobody won :(";
        }
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(ct, text, duration);
        toast.show();
    }

    public int getWinner() {
        if(Global.p1choice == 1 && Global.p2choice==2) {
            Global.p2wins = Global.p2wins + 1;
            return 2;
        }
        if(Global.p1choice == 2 && Global.p2choice == 3) {
            Global.p2wins = Global.p2wins + 1;
            return 2;
        }
        if(Global.p1choice == 3 && Global.p2choice == 1) {
            Global.p2wins = Global.p2wins + 1;
            return 2;
        }
        if(Global.p2choice == 1 && Global.p1choice == 2) {
            Global.p1wins = Global.p1wins + 1;
            vibrate();
            return 1;
        }
        if(Global.p2choice == 2 && Global.p1choice == 3) {
            Global.p1wins = Global.p1wins + 1;
            vibrate();
            return 1;
        }
        if(Global.p2choice == 3 && Global.p1choice == 1) {
            Global.p1wins = Global.p1wins + 1;
            vibrate();
            return 1;
        }

        return 0;
    }

    public void setScore() {
        TextView p2wins = findViewById(R.id.p2wins);
        TextView p1wins = findViewById(R.id.p1wins);
        p2wins.setText(Integer.toString(Global.p2wins));
        p1wins.setText(Integer.toString(Global.p1wins));
    }

    public void vibrate() {
        long pattern[]={0,200,100,300,400}; // or you can just set a duration also in ms
        Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(pattern, -1);
    }
}
