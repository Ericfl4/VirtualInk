package com.example.virtualink.d1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualink.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, styleView;
    public MyViewHolder(@NonNull View itemView){
        super(itemView);
        imageView=itemView.findViewById(R.id.imageview);
        nameView=itemView.findViewById(R.id.name);
        styleView =itemView.findViewById(R.id.style);
    }
}
