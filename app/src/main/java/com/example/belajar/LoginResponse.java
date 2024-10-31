package com.example.belajar;

// kelas LoginResponse untuk menyimpan respons dari API saat login
public class LoginResponse {
    // variabel untuk status login dan token autentikasi
    private String status;
    private String token;

    // getter untuk mengambil nilai status
    public String getStatus() {
        return status;
    }

    // setter untuk menetapkan nilai status
    public void setStatus(String status) {
        this.status = status;
    }

    // getter untuk mengambil nilai token
    public String getToken() {
        return token;
    }

    // setter untuk menetapkan nilai token
    public void setToken(String token) {
        this.token = token;
    }
}

// menyimpan status dan token dari server yang digunakan sebagai tanda berhasil atau tidaknya login.
