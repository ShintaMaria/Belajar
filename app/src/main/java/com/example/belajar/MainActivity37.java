package com.example.belajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity37 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main37);

        ImageView showJson = findViewById(R.id.json);
        ImageView showJsonApi = findViewById(R.id.json_api);
        ImageView showMovieDB = findViewById(R.id.moviedb);

        showJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity37.this, JsonParseActivity37.class);
                startActivity(intent);
            }
        });


        showJsonApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity37.this, JsonAPIActivity37.class);
                startActivity(intent);
            }
        });

        showMovieDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity37.this, MovieDBActivity37.class);
                startActivity(intent);
            }
        });
    }
}
