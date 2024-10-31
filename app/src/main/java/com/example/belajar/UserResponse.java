package com.example.belajar;

public class UserResponse {
    private String status;
    private User data;

    // Getter dan Setter untuk status dan data
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
