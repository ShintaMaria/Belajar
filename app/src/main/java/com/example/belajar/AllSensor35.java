package com.example.belajar;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class AllSensor35 extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_sensor35);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        ListView listView = findViewById(R.id.lv_sensors);
        listView.setAdapter(new MySensorAdapter(this, R.layout.item_sensor35, sensorList));
    }

    // Adapter untuk ListView
    class MySensorAdapter extends ArrayAdapter<Sensor> {
        private int txtResourceID;
        private List<Sensor> sensors;

        public MySensorAdapter(@NonNull Context context, int resource, List<Sensor> sensors) {
            super(context, resource, sensors);
            this.txtResourceID = resource;
            this.sensors = sensors;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int idSensor = position + 1;
            ViewHolder viewHolder = null;

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(txtResourceID, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.sensorTextView = convertView.findViewById(R.id.txt_item_sensor);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Sensor sensor = sensors.get(position);

            if (sensor != null) {
                int sensorId = position + 1;
                viewHolder.sensorTextView.setText(sensorId + ". Name: " + sensor.getName() + "\nType: " + sensor.getType() +
                        "\nPower: " + sensor.getPower() + "mAh\nMax Range: " + sensor.getMaximumRange());
            }

            return convertView;
        }
    }

    static class ViewHolder {
        TextView sensorTextView;
    }
}
