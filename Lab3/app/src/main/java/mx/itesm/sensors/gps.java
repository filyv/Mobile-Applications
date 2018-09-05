package mx.itesm.sensors;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class gps extends AppCompatActivity implements LocationListener {

    public LocationManager lm;
    public String provider;
    public Location loc;
    public double lng;
    public double lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        Button gpsButton =(Button)findViewById(R.id.button_gps);
        gpsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                lm = (LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
                Criteria c = new Criteria();
                provider = lm.getBestProvider(c, false);
                loc = lm.getLastKnownLocation(provider);


                if(loc != null)  {
                    lng = loc.getLongitude();
                    lat = loc.getLatitude();
                    Toast.makeText(getApplicationContext(), "Long = " + lng + "; Lat = " + lat , Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(getApplicationContext(), "No location" , Toast.LENGTH_LONG).show();;
                }

            }
        });
    }


    @Override
    public void onLocationChanged(Location location)  {
        lng = loc.getLongitude();
        lat = loc.getLatitude();
        Toast.makeText(getApplicationContext(), "Long = " + lng + "; Lat = " + lat , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        lng = loc.getLongitude();
        lat = loc.getLatitude();
        Toast.makeText(getApplicationContext(), "Long = " + lng + "; Lat = " + lat , Toast.LENGTH_LONG).show();
    }

}
