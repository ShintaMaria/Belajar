package com.example.belajar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BenuaAdapter extends RecyclerView.Adapter<BenuaAdapter.BenuaViewHolder> {

    private List<String> benuaList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String benua);
    }

    public BenuaAdapter(List<String> benuaList, OnItemClickListener listener) {
        this.benuaList = benuaList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BenuaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_benua_adapter, parent, false);
        return new BenuaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BenuaViewHolder holder, int position) {
        String benua = benuaList.get(position);
        holder.benuaTextView.setText(benua);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(benua);
            }
        });
    }

    @Override
    public int getItemCount() {
        return benuaList.size();
    }

    public class BenuaViewHolder extends RecyclerView.ViewHolder {
        TextView benuaTextView;

        public BenuaViewHolder(@NonNull View itemView) {
            super(itemView);
            benuaTextView = itemView.findViewById(R.id.benuaTextView);
        }
    }
}
