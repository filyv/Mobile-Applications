package mx.itesm;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mx.itesm.sensors.R;

public class vibration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        Button vibButton =(Button)findViewById(R.id.button_vibrate);
        vibButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //Set the pattern for vibration
                long pattern[]={0,200,100,300,400}; // or you can just set a duration also in ms
                Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(pattern, -1);


            }
        });
    }
}
