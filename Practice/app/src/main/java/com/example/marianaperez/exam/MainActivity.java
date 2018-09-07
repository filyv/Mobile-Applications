package com.example.marianaperez.exam;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int getChange(double payed, double total) {
        double change = payed-total;
        if(change<0) {
            return -1;
        }
        Global.change500 = Math.round((int)change/500);
        change=change%500;
        Global.change200 = Math.round((int)change/200);
        change=change%200;
        Global.change100 = Math.round((int)change/100);
        change=change%100;
        Global.change50 = Math.round((int)change/50);
        change=change%50;
        Global.change20 = Math.round((int)change/20);
        change=change%20;
        Global.change10 = Math.round((int)change/10);
        change=change%10;
        Global.change1 = Math.round((int)change/1);
        change=change%1;
        if(change == 0.5) {
            Global.change05 = 0;
        }
        return 0;
    }

    /** Called when the user taps the Send button */
    public void getValues(View view) {

        EditText textPayed = (EditText) findViewById(R.id.payed);
        EditText textTotal = (EditText) findViewById(R.id.total);
        double payed = Double.parseDouble(textPayed.getText().toString());
        double total = Double.parseDouble(textTotal.getText().toString());
        if(getChange(payed,total) == -1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("Alert!");

            // set dialog message
            alertDialogBuilder
                    .setMessage("The customer is not paying the bill")
                    .setCancelable(false)
/*                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    proximity.this.finish();
                                }
                            })*/
                    .setNegativeButton("ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else {
            getChange(payed, total);
            Intent intent = new Intent(this, displayChange.class);
            startActivity(intent);
        }

    }
}
