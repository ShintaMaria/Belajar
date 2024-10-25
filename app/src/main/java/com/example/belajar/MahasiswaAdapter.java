package com.example.belajar;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaViewHolder> {
    private ArrayList<Mahasiswa> listMahasiswa;

    public MahasiswaAdapter(ArrayList<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item37, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        holder.tvnama.setText(listMahasiswa.get(position).getNama());
        holder.tvnpm.setText(listMahasiswa.get(position).getNpm());
        holder.tvnohp.setText(listMahasiswa.get(position).getNohp());
    }

    @Override
    public int getItemCount() {
        return (listMahasiswa != null) ? listMahasiswa.size() : 0;
    }
}


