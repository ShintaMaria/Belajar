package com.example.belajar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MaterialDesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        // Deklarasi dan inisialisasi button
        Button textButton = findViewById(R.id.text_button);

        // Menambahkan event listener untuk button
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan pesan Toast ketika button diklik
                Toast.makeText(MaterialDesign.this, "Button diklik!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

