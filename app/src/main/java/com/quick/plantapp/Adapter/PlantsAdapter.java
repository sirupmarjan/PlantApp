package com.quick.plantapp.Adapter;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.quick.plantapp.R;
import com.quick.plantapp.Room.Plants;
import com.quick.plantapp.ViewHolder.mPlantHolder;

import java.util.List;

public class PlantsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Plants> datalist;
    private Context context;
    private mPlantHolder mHolder;
    public PlantsAdapter(Context context, List<Plants>datalist){
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
        Plants data = datalist.get(position);

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
