package com.example.belajar;

// import pustaka retrofit untuk membuat panggilan api
import retrofit2.Call;
import com.example.belajar.LoginResponse;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

// antarmuka untuk mendefinisikan endpoint api
public interface ApiService {

    // endpoint untuk melakukan login
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    // endpoint untuk mendapatkan data user dengan token
    @GET("getData.php")
    Call<UserResponse> getData(@Query("token") String token);  // mengirimkan token sebagai query parameter

}

//ApiService adalah interface Retrofit yang mendefinisikan endpoint API, seperti:
//login: Metode POST untuk memverifikasi username dan password.
//getData: Metode GET yang mengambil data pengguna berdasarkan token yang diterima setelah login berhasil.
