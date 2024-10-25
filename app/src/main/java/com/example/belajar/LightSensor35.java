package com.example.belajar;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LightSensor35 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private TextView txtBrightnessInfo;
    private CustomGraphView35 customGraphView;
    private double[] dataPoints = new double[33]; // array untuk menyimpan data cahaya
    private int dataIndex = 0; // indeks data
    private MediaPlayer mPlayer;
    private String currentAudio = ""; // melacak file audio yang sedang dimainkan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // mengaktifkan mode edge-to-edge
        setContentView(R.layout.activity_light_sensor35); // menghubungkan ke layout activity_light_sensor35

        txtBrightnessInfo = findViewById(R.id.txt_brightness_info); // menghubungkan teks informasi brightness

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); // mendapatkan layanan sensor
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT); // mendapatkan sensor cahaya

        // cek apakah sensor cahaya tersedia
        if (lightSensor == null) {
            txtBrightnessInfo.setText("Sensor tidak ditemukan");
        } else {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL); // mendaftarkan listener untuk sensor cahaya
        }

        customGraphView = findViewById(R.id.custom_graph); // menghubungkan customGraphView
        customGraphView.setGraphColor(Color.RED); // mengatur warna grafik menjadi merah
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType(); // mendapatkan tipe sensor
        if (sensorType == Sensor.TYPE_LIGHT) {
            float brightnessValue = sensorEvent.values[0]; // mendapatkan nilai cahaya
            txtBrightnessInfo.setText(getResources().getString(R.string.label_brightness, brightnessValue)); // menampilkan nilai cahaya

            // simpan data cahaya dalam array dan update grafik
            dataPoints[dataIndex] = brightnessValue;
            dataIndex = (dataIndex + 1) % dataPoints.length;
            customGraphView.setDataPoints(dataPoints); // update data pada grafik


            if (brightnessValue < 5) {
                playAudio("cahaya_gelap.mp3");
            } else if (brightnessValue > 200) {
                playAudio("cahaya_terang.mp3");
            }
        }
    }

    private void playAudio(String fileName) {
        // hindari perulangan audio
        if (mPlayer != null && mPlayer.isPlaying()) {
            if (fileName.equals(currentAudio)) {
                // audio sudah diputar, tidak perlu diputar lagi
                return;
            }
            mPlayer.stop(); // hentikan audio yang sedang dimainkan
            mPlayer.reset(); // reset media player
        }

        mPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor as = this.getAssets().openFd(fileName);
            mPlayer.setDataSource(as.getFileDescriptor(), as.getStartOffset(), as.getLength());
            mPlayer.prepare();
            mPlayer.start();
            currentAudio = fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        sensorManager.unregisterListener(this, lightSensor); // berhenti mendengarkan sensor saat tombol kembali ditekan
        if (mPlayer != null) {
            mPlayer.release(); // lepaskan media player saat keluar
            currentAudio = ""; // reset pelacakan audio
        }
    }
}
