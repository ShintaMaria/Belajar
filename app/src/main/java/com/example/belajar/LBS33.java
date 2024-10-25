package com.example.belajar;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LBS33 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager lm;
    private LocationListener locationListener;
    private boolean permissionGranted = false;
    private boolean locationShown = false; // variabel untuk melacak apakah toast sudah ditampilkan
    private static final int REQUEST_COURSE_ACCESS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbs33);

        // mendapatkan referensi ke layanan lokasi sistem (locationmanager)
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // mendapatkan supportmapfragment dan menunggu hingga peta siap digunakan
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        // jika izin diberikan, hentikan update lokasi
        if (permissionGranted) {
            lm.removeUpdates(locationListener);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // memeriksa izin lokasi ketika aplikasi dilanjutkan
        checkLocationPermission();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // peta siap digunakan, simpan referensi ke objek googlemap
        mMap = googleMap;

        // aktifkan kontrol zoom pada peta
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // memeriksa izin lokasi, jika diizinkan, tambahkan listener lokasi
        checkLocationPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // memeriksa hasil permintaan izin lokasi
        if (requestCode == REQUEST_COURSE_ACCESS) {
            permissionGranted = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    // fungsi untuk memeriksa izin lokasi dan meminta izin jika diperlukan
    private void checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // meminta izin akses lokasi jika belum diberikan
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_COURSE_ACCESS);
        } else {
            // izin diberikan, tambahkan listener lokasi
            permissionGranted = true;
            if (locationListener == null) {
                locationListener = new MyLocationListener();
            }
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {
            // jika lokasi berubah dan toast belum ditampilkan, tampilkan pesan toast dengan lat dan long baru
            if (!locationShown && loc != null) {
                // menampilkan pesan toast dengan koordinat lokasi baru
                Toast.makeText(getBaseContext(), "Location changed: Lat: " + loc.getLatitude() + " Lng: " + loc.getLongitude(), Toast.LENGTH_SHORT).show();

                // pindahkan kamera peta ke lokasi baru
                LatLng currentLocation = new LatLng(loc.getLatitude(), loc.getLongitude());
                if (mMap != null) {
                    // menambah marker di lokasi saat ini dan memperbesar kamera
                    mMap.addMarker(new MarkerOptions().position(currentLocation).title("Lokasi Saat Ini"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
                }
                // tandai bahwa toast telah ditampilkan
                locationShown = true;
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            // tampilkan pesan jika provider lokasi dinonaktifkan
            Toast.makeText(getBaseContext(), provider + " Disabled", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderEnabled(String provider) {
            // tampilkan pesan jika provider lokasi diaktifkan
            Toast.makeText(getBaseContext(), provider + " Enabled", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }
}
