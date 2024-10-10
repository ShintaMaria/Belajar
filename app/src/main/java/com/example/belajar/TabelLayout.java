package com.example.belajar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TabelLayout extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private TextView textViewStatus;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_layout);

        // Inisialisasi elemen-elemen dari layout
        editTextUsername = findViewById(R.id.screenName);
        editTextPassword = findViewById(R.id.password);
        textViewStatus = findViewById(R.id.status);
        buttonSubmit = findViewById(R.id.save);

        // Mengatur listener pada tombol submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari EditText
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Validasi input sederhana
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(TabelLayout.this, "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    // Menampilkan pesan sukses jika input valid
                    textViewStatus.setText("Login berhasil");
                    Toast.makeText(TabelLayout.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

