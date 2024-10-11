package com.example.belajar;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AksesSensor35 extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgAllSensor, imgProximitySensor, imgLightSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_akses_sensor35);
        imgAllSensor =  findViewById(R.id.img_list_all_sensor);
        imgLightSensor = findViewById(R.id.img_ligh_sensor);
        imgProximitySensor = findViewById(R.id.img_proximity_sensor);
        imgAllSensor.setOnClickListener(this);
        imgLightSensor.setOnClickListener(this);
        imgProximitySensor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.img_list_all_sensor){
            Intent intentAll = new Intent(this, AllSensorActivity35.class);
            startActivity(intentAll);
        } else if (id == R.id.img_ligh_sensor){
            Intent intentLight = new Intent(this, LightSensorActivity35.class);
            startActivity(intentLight);
        } else if (id == R.id.img_proximity_sensor){
            Intent intentProximity = new Intent(this, ProximitySensorActivity35.class);
            startActivity(intentProximity);
        }
    }
}