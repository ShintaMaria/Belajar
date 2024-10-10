package com.example.belajar;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.belajar.R;

public class FrameLayout extends AppCompatActivity {

    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        // Inisialisasi ImageView dan Button
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        // Event listener untuk tombol
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FrameLayout.this, "Tombol diklik!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
