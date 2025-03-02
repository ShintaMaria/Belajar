package com.example.belajar;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

// kelas untuk mengelola koneksi api menggunakan retrofit
public class ApiClient {
    // url dasar untuk menghubungkan ke server
    private static final String BASE_URL = "http://192.168.1.14/retrofitmobile/";

    // variabel retrofit sebagai instance tunggal (singleton) untuk koneksi
    private static Retrofit retrofit;

    // metode untuk mendapatkan instance retrofit
    public static Retrofit getRetrofitInstance(){
        // jika belum ada instance retrofit, buat baru
        if(retrofit == null){
            // membangun instance retrofit dengan url dasar dan converter gson
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // konverter json ke objek java
                    .build();
        }
        return retrofit;
    }
}
//berfungsi untuk membuat instance Retrofit, sebuah pustaka untuk menangani komunikasi HTTP dengan server.
// URL dasar (BASE_URL) adalah alamat server lokal yang digunakan untuk mengakses skrip PHP yang menangani
// login dan data pengguna.
