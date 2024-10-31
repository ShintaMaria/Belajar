package com.example.belajar;

// kelas User untuk menyimpan informasi pengguna yang diambil dari respons API
public class User {
    // variabel untuk menyimpan id pengguna, username, password, dan token
    private String id;
    private String username; // menyimpan username dari pengguna
    private String password; // menyimpan password pengguna jika diperlukan
    private String token; // menyimpan token autentikasi

    // getter untuk mengambil nilai id pengguna
    public String getId() {
        return id;
    }

    // setter untuk menetapkan nilai id pengguna
    public void setId(String id) {
        this.id = id;
    }

    // getter untuk mengambil nilai username
    public String getUsername() {
        return username;
    }

    // setter untuk menetapkan nilai username
    public void setUsername(String username) {
        this.username = username;
    }

    // getter untuk mengambil nilai password
    public String getPassword() {
        return password;
    }

    // setter untuk menetapkan nilai password
    public void setPassword(String password) {
        this.password = password;
    }

    // getter untuk mengambil nilai token
    public String getToken() {
        return token;
    }

    // setter untuk menetapkan nilai token
    public void setToken(String token) {
        this.token = token;
    }

    // metode toString untuk menampilkan informasi pengguna sebagai teks
    @Override
    public String toString() {
        return "ID: " + id + "\nUsername: " + username + "\nToken: " + token;
    }
}
// menyimpan data pengguna yang diperoleh