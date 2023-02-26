package com.example.virtualink.d2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualink.R;


public class MyViewHolderEstilos extends RecyclerView.ViewHolder {
    ImageView imageViewEstilos;
    TextView nameViewEstilos;

    public MyViewHolderEstilos(@NonNull View itemView){
        super(itemView);
        imageViewEstilos=itemView.findViewById(R.id.imageviewEstilos);
        nameViewEstilos=itemView.findViewById(R.id.nameEstilos);
    }
}
