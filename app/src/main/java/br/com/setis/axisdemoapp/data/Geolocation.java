package br.com.setis.axisdemoapp.data;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.Context.LOCATION_SERVICE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.location.LocationManager.GPS_PROVIDER;
import static android.location.LocationManager.NETWORK_PROVIDER;

public class Geolocation {

    private static final String TAG = Geolocation.class.getSimpleName();

    public static void init(Activity activity) {
        LocationManager locationManager = (LocationManager) activity.getSystemService(LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Log.d(TAG, "onLocationChange = " + location.getLatitude() + ", " + location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d(TAG, "onStatusChanged = " + provider);
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d(TAG, "onProviderEnabled = " + provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d(TAG, "onProviderDisabled = " + provider);
            }
        };

        if (ActivityCompat.checkSelfPermission(activity, ACCESS_FINE_LOCATION) != PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(activity, ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.requestPermissions(new String[]{ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION}, 0);
            }
        }

        if (ActivityCompat.checkSelfPermission(activity, ACCESS_FINE_LOCATION) == PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(activity, ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED) {

            locationManager.requestLocationUpdates(GPS_PROVIDER, 60000, 0, locationListener);
            locationManager.requestLocationUpdates(NETWORK_PROVIDER, 60000, 0, locationListener);
        }
    }

    public static Location getLocation(Activity activity) {

        LocationManager locationManager = (LocationManager) activity.getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(activity, ACCESS_FINE_LOCATION)   == PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(activity, ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED) {

            Location location = locationManager.getLastKnownLocation(GPS_PROVIDER);
            if (location == null) {
                location = locationManager.getLastKnownLocation(NETWORK_PROVIDER);
            }
            return location;
        }

        return null;
    }
}
