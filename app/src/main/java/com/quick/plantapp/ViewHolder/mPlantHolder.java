package com.quick.plantapp.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quick.plantapp.R;

public class mPlantHolder extends RecyclerView.ViewHolder {
    public TextView nJudul;
    public TextView nDesc;
    public LinearLayout nParentList;

    public mPlantHolder(@NonNull View itemView) {
        super(itemView);
        nJudul = itemView.findViewById(R.id.tv_judul);
        nDesc =  itemView.findViewById(R.id.tv_deskripsi);
        nParentList = itemView.findViewById(R.id.ll_list);
    }
}
