package com.quick.plantapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quick.plantapp.Activity.ViewAct;
import com.quick.plantapp.R;
import com.quick.plantapp.Room.Plants;
import com.quick.plantapp.ViewHolder.mPlantHolder;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "PlantAdapter";
    private List<Plants> datalist;
    private Context context;
    ViewAct view;

    public PlantAdapter(Context context, List<Plants>datalist){
        this.datalist = datalist;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new mPlantHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setClick(((mPlantHolder)holder).nParentList, position);
        setJudul(((mPlantHolder)holder).nJudul, datalist.get(position).getJudul());
        setDeskripsi(((mPlantHolder)holder).nDesc, datalist.get(position).getDeskripsi());
    }

    private void setClick(LinearLayout parent, final int position){
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTransfer(datalist.get(position).getJudul(), datalist.get(position).getDeskripsi());
            }
        });
    }

    private void setJudul(TextView judul, String textJudul){
        judul.setText(textJudul);
    }
    private void setDeskripsi(TextView deskripsi, String text){
        deskripsi.setText(text);
    }

    public void setTransfer(String judul, String desc){
        Log.d(TAG, judul);
        Log.d(TAG, desc);
        Intent i = new Intent(context, ViewAct.class);
        i.putExtra("judul", judul);
        i.putExtra("desc", desc);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


}
