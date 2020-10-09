package com.quick.plantapp.Adapter;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.quick.plantapp.R;
import com.quick.plantapp.Room.Plants;

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

    public class mPlantHolder extends RecyclerView.ViewHolder {
        TextView nJudul, nDesc;

        public mPlantHolder(@NonNull View itemView) {
            super(itemView);
            nJudul = itemView.findViewById(R.id.tv_judul);
            nDesc =  itemView.findViewById(R.id.tv_deskripsi);
        }
}
