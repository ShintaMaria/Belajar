package com.example.belajar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AutoCompleteTextView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> listMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);

        // Add data to the list
        tambahData();

        // Set up the RecyclerView with the adapter and layout manager
        adapter = new MahasiswaAdapter(listMahasiswa);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    // Method to add data to the list
    private void tambahData() {
        listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new Mahasiswa("Shinta", "0987654", "0854697114"));
        listMahasiswa.add(new Mahasiswa("Indah", "09864324", "0879621563"));
        listMahasiswa.add(new Mahasiswa("Anggraini", "0987845", "0863245198"));
        listMahasiswa.add(new Mahasiswa("Ria", "0983115", "08123658974"));

        // Additional data
        listMahasiswa.add(new Mahasiswa("Dimas Maulana", "1414370309", "123456789"));
        listMahasiswa.add(new Mahasiswa("Fadly Yonk", "1214234560", "987654321"));
        listMahasiswa.add(new Mahasiswa("Ariyandi Nugraha", "1214230345", "987646765"));
        listMahasiswa.add(new Mahasiswa("Aham Siswana", "1214370985", "098758124"));
    }
}
