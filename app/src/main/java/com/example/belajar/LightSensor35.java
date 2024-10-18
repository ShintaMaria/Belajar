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
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LightSensor35 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private TextView txtBrightnessInfo;
    private CustomGraphView35 customGraphView;
    private double[] dataPoints = new double[33]; // Array untuk menyimpan data cahaya
    private int dataIndex = 0; // Indeks data
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_light_sensor35);

        txtBrightnessInfo = findViewById(R.id.txt_brightness_info);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null) {
            txtBrightnessInfo.setText("Sensor tidak ditemukan");
        } else {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        customGraphView = findViewById(R.id.custom_graph);
        customGraphView.setGraphColor(Color.RED); // Set warna grafik
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        if (sensorType == Sensor.TYPE_LIGHT) {
            float brightnessValue = sensorEvent.values[0];
            txtBrightnessInfo.setText(getResources().getString(R.string.label_brightness, brightnessValue));

            // Simpan data cahaya dalam array dan update grafik
            dataPoints[dataIndex] = brightnessValue; // Simpan nilai ke array
            dataIndex = (dataIndex + 1) % dataPoints.length; // Update indeks dengan rollover
            customGraphView.setDataPoints(dataPoints); // Update data grafik

            // Mainkan audio berdasarkan intensitas cahaya
            if (brightnessValue == 0) {
                playAudio("cahaya_gelap.mp3");
            } else if (brightnessValue > 100) {
                playAudio("cahaya_terang.mp3");
            }
        }
    }

    private void playAudio(String fileName) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
            mPlayer.reset();
        }
        mPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor as = this.getAssets().openFd(fileName);
            mPlayer.setDataSource(as.getFileDescriptor(), as.getStartOffset(), as.getLength());
            mPlayer.prepare();
            mPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // Tidak digunakan, tapi harus diimplementasikan
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        sensorManager.unregisterListener(this, lightSensor);
        if (mPlayer != null) {
            mPlayer.release(); // Lepaskan media player saat keluar
        }
    }
}
