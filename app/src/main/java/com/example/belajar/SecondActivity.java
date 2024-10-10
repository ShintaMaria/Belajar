package com.example.belajar;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView txtHello;
    private String nama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Inisialisasi TextView
        txtHello = findViewById(R.id.txtHello);

        // Mengambil data dari intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nama = extras.getString(KEY_NAME);
            txtHello.setText("Hello, " + nama + "!");
        }
    }
}
