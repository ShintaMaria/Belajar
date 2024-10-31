package com.example.belajar;

// kelas UserResponse untuk menyimpan respons API yang mencakup status dan data pengguna
public class UserResponse {
    // variabel untuk menyimpan status respons dan objek data pengguna
    private String status;
    private User data;

    // getter untuk mengambil nilai status respons
    public String getStatus() {
        return status;
    }

    // setter untuk menetapkan nilai status respons
    public void setStatus(String status) {
        this.status = status;
    }

    // getter untuk mengambil data pengguna dalam bentuk objek User
    public User getData() {
        return data;
    }

    // setter untuk menetapkan data pengguna
    public void setData(User data) {
        this.data = data;
    }
}

// menampilkan status dan data pengguna yang berhasil diambil.