package com.example.belajar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Deklarasi dan Menginisialisasi variable nama dengan Label Nama dari Layout activity_welcome
        TextView nama = findViewById(R.id.tv_namaMain);

        // Mengambil data user yang sedang login dari SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String loggedInUser = sharedPreferences.getString("username", null);

        // Menampilkan nama pengguna yang sedang login di Label Nama
        if (loggedInUser != null) {
            nama.setText(loggedInUser);
        } else {
            // Jika tidak ada pengguna yang sedang login, kembalikan ke halaman login
            startActivity(new Intent(Welcome.this, KonsepPreferences30.class));
            finish();
        }

        // Menangani proses logout
        findViewById(R.id.button_logoutMain).setOnClickListener(v -> {
            // Menghapus status login dari SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();  // Menghapus semua data yang disimpan
            editor.apply();

            // Mengarahkan kembali ke halaman login
            startActivity(new Intent(Welcome.this, KonsepPreferences30.class));
            finish();
        });
    }
}
