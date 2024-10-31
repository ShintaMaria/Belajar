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
    TextView userDataText;
    Button btnLogout;
    ApiService apiService;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main41);

        userDataText = findViewById(R.id.userDataText);
        btnLogout = findViewById(R.id.btn_logout); // Memanggil tombol btn_logout
        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        // Mengambil token dari Intent
        token = getIntent().getStringExtra("TOKEN");

        if (token != null) {
            getData();
        } else {
            Toast.makeText(this, "Token tidak tersedia", Toast.LENGTH_SHORT).show();
        }

        // Mengatur aksi klik untuk tombol logout
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tambahkan logika logout di sini
                Toast.makeText(MainActivity41.this, "Logout berhasil", Toast.LENGTH_SHORT).show();
                finish(); // Mengakhiri aktivitas setelah logout
            }
        });
    }

    private void getData() {
        Call<UserResponse> call = apiService.getData(token);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body() != null && response.body().getStatus().equals("success")) {
                    userDataText.setText(response.body().getData().toString());
                } else {
                    Toast.makeText(MainActivity41.this, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(MainActivity41.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                Log.e("MainActivity41", "onFailure: ", t);
            }
        });
    }
}
