package com.example.belajar;

public class Mahasiswa {
    private String nama;
    private String npm;
    private String nohp;

    public Mahasiswa(String nama, String npm, String nohp) {
        this.nama = nama;
        this.npm = npm;
        this.nohp = nohp;
    }

    public String getNama() {
        return nama;
    }
    public String getNpm() {
        return npm;
    }
    public String getNohp() {
        return nohp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}