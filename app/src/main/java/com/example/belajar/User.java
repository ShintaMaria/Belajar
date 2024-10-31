package com.example.belajar;

public class User {
    private String id;
    private String username; // Ubah dari name menjadi username
    private String password; // Menyimpan password (jika diperlukan)
    private String token; // Menyimpan token

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nUsername: " + username + "\nToken: " + token;
    }
}
