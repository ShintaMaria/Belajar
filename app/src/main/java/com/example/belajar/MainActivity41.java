package com.example.belajar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity41 extends AppCompatActivity {
    // mendeklarasikan komponen textview, button logout, apiService, dan token
    TextView userDataText;
    Button btnLogout;
    ApiService apiService;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main41);

        // menghubungkan komponen dengan elemen layout
        userDataText = findViewById(R.id.userDataText);
        btnLogout = findViewById(R.id.btn_logout); // memanggil tombol logout
        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        // mengambil token yang dikirim dari LoginActivity
        token = getIntent().getStringExtra("TOKEN");

        // jika token tersedia, panggil metode getData untuk mengambil data user
        if (token != null) {
            getData();
        } else {
            // jika token tidak tersedia, tampilkan pesan error
            Toast.makeText(this, "Token tidak tersedia", Toast.LENGTH_SHORT).show();
        }

        // mengatur aksi klik untuk tombol logout
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // menampilkan pesan logout berhasil dan menutup activity
                Toast.makeText(MainActivity41.this, "Logout berhasil", Toast.LENGTH_SHORT).show();
                finish(); // mengakhiri aktivitas setelah logout
            }
        });
    }

    // metode untuk mengambil data user menggunakan token
    private void getData() {
        // memanggil endpoint getData dengan token
        Call<UserResponse> call = apiService.getData(token);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                // jika respons sukses dan statusnya "success"
                if (response.body() != null && response.body().getStatus().equals("success")) {
                    // menampilkan data user di userDataText
                    userDataText.setText(response.body().getData().toString());
                } else {
                    // menampilkan pesan jika gagal mendapatkan data
                    Toast.makeText(MainActivity41.this, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                // menampilkan pesan jika terjadi kesalahan pada jaringan atau server
                Toast.makeText(MainActivity41.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                Log.e("MainActivity41", "onFailure: ", t); // mencatat log kesalahan untuk debugging
            }
        });
    }
}

//Aktivitas utama ini menampilkan data pengguna yang diambil dari server menggunakan token.
// Jika token valid, data pengguna ditampilkan di layar, dan terdapat tombol logout untuk mengakhiri
// sesi pengguna.
