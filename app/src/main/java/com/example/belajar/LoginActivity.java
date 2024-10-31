package com.example.belajar;

// import pustaka untuk komponen android yang digunakan dalam login
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.belajar.ApiClient;
import com.example.belajar.ApiService;
import com.example.belajar.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    // mendeklarasikan komponen input username, password, tombol login, dan layanan api
    EditText usernameInput, passwordInput;
    Button loginButton;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login41);

        // menghubungkan komponen dengan elemen layout
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        // inisialisasi apiService dengan membuat instance dari ApiClient
        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        // mengatur aksi tombol login untuk memanggil fungsi loginUser()
        loginButton.setOnClickListener(v -> loginUser());
    }

    // metode untuk memproses login
    private void loginUser(){
        // mengambil input dari pengguna
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        // membuat panggilan api untuk login dengan username dan password
        Call<LoginResponse> call = apiService.login(username, password);
        call.enqueue(new Callback<LoginResponse>(){
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response){
                // jika respons berhasil dan statusnya "success"
                if(response.body() != null && response.body().getStatus().equals("success")){
                    // menyimpan token dari respons
                    String token = response.body().getToken();

                    // berpindah ke MainActivity41 dan mengirimkan token
                    Intent intent = new Intent(LoginActivity.this, MainActivity41.class);
                    intent.putExtra("TOKEN", token);
                    startActivity(intent);
                } else {
                    // jika login gagal, menampilkan pesan
                    Toast.makeText(LoginActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // menampilkan pesan error jika terjadi kesalahan jaringan atau server
                Toast.makeText(LoginActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_LONG).show();

                // mencatat log kesalahan untuk debugging
                Log.e("LoginActivity", "onFailure: ", t);
            }
        });
    }
}

// pengguna memasukkan username dan password. Jika berhasil, respons server akan mengembalikan token
// yang disimpan di Intent untuk mengakses halaman berikutnya (MainActivity41). Jika login gagal,
// pesan error ditampilkan.