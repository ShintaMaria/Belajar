package com.example.belajar;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
    public TextView tvnama, tvnpm, tvnohp;

    public MahasiswaViewHolder(@NonNull View itemView) {
        super(itemView);
        tvnama = itemView.findViewById(R.id.nama_mahasiswa);
        tvnpm = itemView.findViewById(R.id.npm_mahasiswa);
        tvnohp = itemView.findViewById(R.id.nohp_mahasiswa);
    }
}
