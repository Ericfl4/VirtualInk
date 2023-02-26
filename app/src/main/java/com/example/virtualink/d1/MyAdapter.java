package com.example.virtualink.d1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualink.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Tatuador> listaTatuador;

    public MyAdapter(Context context, List<Tatuador> listaTatuador) {
        this.context = context;
        this.listaTatuador = listaTatuador;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(listaTatuador.get(position).getName());
        holder.styleView.setText(listaTatuador.get(position).getStyle());
        holder.imageView.setImageResource(listaTatuador.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listaTatuador.size();
    }
}
