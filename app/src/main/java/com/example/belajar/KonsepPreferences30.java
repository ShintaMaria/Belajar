package com.example.belajar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class KonsepPreferences30 extends AppCompatActivity {

    // Deklarasi variabel untuk tampilan (view)
    private ImageView logoImage;
    private EditText edtNama, edtPassword;
    private Button btnMasuk;
    private TextView txtRegister;

    // Fungsi yang dijalankan saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsep_preferences30);

        // Inisialisasi view dengan id yang sesuai pada layout
        logoImage = findViewById(R.id.logoImage);
        edtNama = findViewById(R.id.edtNama);
        edtPassword = findViewById(R.id.edtPassword);
        btnMasuk = findViewById(R.id.btnMasuk);
        txtRegister = findViewById(R.id.txtRegister);

        // Fungsi yang dijalankan saat tombol login diklik
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil input nama dan password dari EditText
                String nama = edtNama.getText().toString();
                String password = edtPassword.getText().toString();

                // Validasi sederhana untuk memastikan field tidak kosong
                if (nama.isEmpty() || password.isEmpty()) {
                    // Menampilkan pesan jika nama atau password kosong
                    Toast.makeText(KonsepPreferences30.this, "Nama dan Password harus diisi!", Toast.LENGTH_SHORT).show();
                } else {
                    // Memuat data pengguna yang tersimpan di SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                    String savedUsername = sharedPreferences.getString("username", null);
                    String savedPassword = sharedPreferences.getString("password", null);

                    // Memeriksa apakah input nama dan password sesuai dengan yang tersimpan
                    if (nama.equals(savedUsername) && password.equals(savedPassword)) {
                        // Jika data cocok, tampilkan pesan berhasil dan lanjut ke aktivitas berikutnya
                        Toast.makeText(KonsepPreferences30.this, "Berhasil Masuk", Toast.LENGTH_SHORT).show();

                        // Membuat intent untuk pindah ke aktivitas Welcome
                        Intent intent = new Intent(KonsepPreferences30.this, Welcome.class);
                        startActivity(intent);  // Mulai aktivitas Welcome
                        finish();  // Menutup aktivitas saat ini
                    } else {
                        // Jika data tidak cocok, tampilkan pesan kesalahan
                        Toast.makeText(KonsepPreferences30.this, "Nama atau Password salah!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Fungsi yang dijalankan saat teks register diklik
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat intent untuk pindah ke aktivitas pendaftaran (Preferences30)
                Intent intent = new Intent(KonsepPreferences30.this, Preferences30.class);
                startActivity(intent);  // Mulai aktivitas Preferences30
            }
        });
    }
}
