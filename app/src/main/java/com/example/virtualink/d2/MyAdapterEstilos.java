package com.example.virtualink.d2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualink.R;

import java.util.List;


public class MyAdapterEstilos extends RecyclerView.Adapter<MyViewHolderEstilos> {

    Context context;
    List<Estilo> listEstilo;

    public MyAdapterEstilos(Context context, List<Estilo> listEstilo) {
        this.context = context;
        this.listEstilo = listEstilo;
    }

    @NonNull
    @Override
    public MyViewHolderEstilos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderEstilos(LayoutInflater.from(context).inflate(R.layout.item_view_estilos,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderEstilos holder, int position) {
        holder.imageViewEstilos.setImageResource(listEstilo.get(position).getImageEstilo());
        holder.nameViewEstilos.setText(listEstilo.get(position).getNameEstilo());
    }

    @Override
    public int getItemCount() {
        return listEstilo.size();
    }
}
