package com.example.belajar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.app.Fragment;
import androidx.activity.EdgeToEdge;


public class Fragmentt extends AppCompatActivity {
    Button btnFirstFragmentt , btnSecondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        btnFirstFragmentt = (Button) findViewById(R.id.firstFragment);
        btnSecondFragment = (Button) findViewById(R.id.secondFragment);
        btnFirstFragmentt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //load First Fragment
                loadFragment(new FirstFragment());
            }
        });
        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SecondFragment());
            }
        });
    }
    private  void loadFragment(Fragment fragment){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();

    }
}