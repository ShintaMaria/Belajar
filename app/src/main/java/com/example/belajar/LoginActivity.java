package com.example.belajar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.belajar.ApiClient;
import com.example.belajar.ApiService;
import com.example.belajar.LoginResponse;



import com.example.belajar.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText usernameInput, passwordInput;
    Button loginButton;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login41);

        usernameInput= findViewById(R.id.usernameInput);
        passwordInput= findViewById(R.id.passwordInput);
        loginButton= findViewById(R.id.loginButton);
        apiService= ApiClient.getRetrofitInstance().create(ApiService.class);
        loginButton.setOnClickListener(v->loginUser());
    }

    private void loginUser(){
        String username= usernameInput.getText().toString();
        String password= passwordInput.getText().toString();
        Call<LoginResponse> call = apiService.login(username,password);
        call.enqueue(new Callback<LoginResponse>(){
            @Override
            public void onResponse(Call<LoginResponse>call, Response<LoginResponse>response){
                if(response.body()!=null&& response.body().getStatus().equals("success")){
                    String token = response.body().getToken();
                    Intent intent = new Intent(LoginActivity.this, MainActivity41.class);
                    intent.putExtra("TOKEN", token);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"Login gagal",Toast.LENGTH_SHORT).show();
                }}
                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    // Menampilkan pesan kesalahan secara penuh
                    Toast.makeText(LoginActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_LONG).show();

                    // Jika ingin menggunakan Log untuk debugging
                    Log.e("LoginActivity", "onFailure: ", t);
                }


        });
    }
}
