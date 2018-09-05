package mx.itesm.sensors;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {


    Context context;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel =
                    new NotificationChannel(Constants.CHANNEL_ID, Constants.CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
                mChannel.setDescription(Constants.CHANNEL_DESCRIPTION);
                mChannel.enableLights(true);
                mChannel.setLightColor(Color.BLUE);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});

                mNotificationManager.createNotificationChannel(mChannel);
        }

        context = getApplicationContext();



/*        Button phoneButton=(Button)findViewById(R.id.button_phone);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, call.class);
                startActivity(i);
            }
        });

        Button smsButton=(Button)findViewById(R.id.button_txt);
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, sms.class);
                startActivity(i);
            }
        });*/

/*        Button gpsButton=(Button)findViewById(R.id.button_loc);
        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, gps.class);
                startActivity(i);
            }
        });*/

        Button vibButton=(Button)findViewById(R.id.button_vib);
        vibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, vibration.class);
                startActivity(i);
            }
        });
/*
        Button torButton=(Button)findViewById(R.id.button_tor);
        torButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, torch.class);
                startActivity(i);
            }
        });

        Button accButton=(Button)findViewById(R.id.button_acc);
        accButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, accelerometer.class);
                startActivity(i);
            }
        });


        Button gyrButton=(Button)findViewById(R.id.button_gyr);
        gyrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, gyroscope.class);
                startActivity(i);
            }
        });*/


        Button proButton=(Button)findViewById(R.id.button_pro);
        proButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent i = new Intent(context, proximity.class);
                startActivity(i);
            }
        });


    }
}

