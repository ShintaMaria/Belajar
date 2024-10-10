package com.example.belajar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HorizontalScrollVieww extends AppCompatActivity {

    private TextView loginScreenText, welcomeText;
    private Button buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll_view);

        // Menghubungkan tampilan XML dengan Java
//        loginScreenText = findViewById(R.id.loginscrn);
//        welcomeText = findViewById(R.id.fstTxt);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);

        // Menambahkan aksi klik untuk masing-masing tombol
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke activity LinearLayoutActivity
                Intent intent = new Intent(HorizontalScrollVieww.this, LinearLayout9.class);
                startActivity(intent);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorizontalScrollVieww.this, RelativeLayout.class);
                startActivity(intent);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorizontalScrollVieww.this, ConstraintLayout.class);
                startActivity(intent);
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorizontalScrollVieww.this, FrameLayout.class);
                startActivity(intent);
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorizontalScrollVieww.this, TabelLayout.class);
                startActivity(intent);
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorizontalScrollVieww.this, MaterialDesign.class);
                startActivity(intent);
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorizontalScrollVieww.this, ScrollView.class);
                startActivity(intent);
            }
        });


    }
}
