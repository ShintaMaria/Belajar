package com.example.belajar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;

import java.util.Calendar;

public class Preferences30 extends AppCompatActivity {

    // mendeklarasikan variabel untuk tampilan
    private EditText edtNama, edtNoTelpon, edtPassword, edtTanggalLahir, edtAlamat, edtJK;
    private Button btnDaftar;
    private TextView txtLogin;

    // variabel DatePicker
    private DatePickerDialog datePickerDialog;
    private int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences30);

        // menginisialisasi tampilan
        edtNama = findViewById(R.id.edtNama);
        edtJK = findViewById(R.id.edtJK);
        edtNoTelpon = findViewById(R.id.edtNoTelpon);
        edtPassword = findViewById(R.id.edtPassword);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtAlamat = findViewById(R.id.edtAlamat);
        btnDaftar = findViewById(R.id.btnDaftar);
        txtLogin = findViewById(R.id.txtLogin);

        // mengatur DatePickerDialog untuk EditText Tanggal Lahir
        edtTanggalLahir.setInputType(InputType.TYPE_NULL); // menonaktifkan input manual
        edtTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                day = cldr.get(Calendar.DAY_OF_MONTH);
                month = cldr.get(Calendar.MONTH);
                year = cldr.get(Calendar.YEAR);

                // menginisialisasi DatePickerDialog
                datePickerDialog = new DatePickerDialog(Preferences30.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                                // menampilkan tanggal yang dipilih di EditText
                                edtTanggalLahir.setText(selectedDay + "-" + (selectedMonth + 1) + "-" + selectedYear);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        // mengatur onClickListener untuk tombol daftar
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mendapatkan data input pengguna
                String nama = edtNama.getText().toString();
                String jenisKelamin = edtJK.getText().toString().toUpperCase(); // mengubah input menjadi huruf besar
                String noTelpon = edtNoTelpon.getText().toString();
                String password = edtPassword.getText().toString();
                String tanggalLahir = edtTanggalLahir.getText().toString();
                String alamat = edtAlamat.getText().toString();

                // validasi sederhana untuk memeriksa apakah kolom kosong
                if (nama.isEmpty() || jenisKelamin.isEmpty() || noTelpon.isEmpty() || password.isEmpty() || tanggalLahir.isEmpty() || alamat.isEmpty()) {
                    Toast.makeText(Preferences30.this, "semua kolom harus diisi!", Toast.LENGTH_SHORT).show();
                } else {
                    // memeriksa validitas jenis kelamin
                    if (!jenisKelamin.equals("L") && !jenisKelamin.equals("P")) {
                        Toast.makeText(Preferences30.this, "jenis kelamin tidak valid", Toast.LENGTH_SHORT).show();
                    } else {
                        // memeriksa usia pengguna
                        String[] dateParts = tanggalLahir.split("-");
                        int birthYear = Integer.parseInt(dateParts[2]);
                        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                        int age = currentYear - birthYear;

                        if (age < 5) {
                            // menampilkan peringatan jika usia kurang dari 5 tahun
                            Toast.makeText(Preferences30.this, "maaf anda belum cukup umur untuk mendaftar akun ini", Toast.LENGTH_SHORT).show();
                        } else {
                            // menyimpan data ke SharedPreferences
                            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("username", nama);
                            editor.putString("password", password);
                            editor.putString("tanggalLahir", tanggalLahir); // menyimpan tanggal lahir
                            editor.apply(); // menerapkan perubahan

                            Toast.makeText(Preferences30.this, "pendaftaran berhasil", Toast.LENGTH_SHORT).show();

                            // mengalihkan ke layar login setelah pendaftaran
                            Intent intent = new Intent(Preferences30.this, KonsepPreferences30.class);
                            startActivity(intent);
                            finish(); // menutup aktivitas pendaftaran
                        }
                    }
                }
            }
        });

        // mengatur onClickListener untuk teks login
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigasi ke layar login
                Intent intent = new Intent(Preferences30.this, KonsepPreferences30.class);
                startActivity(intent);
            }
        });
    }
}
