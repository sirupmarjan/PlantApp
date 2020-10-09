package com.quick.plantapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quick.plantapp.R;
import com.quick.plantapp.Room.Plants;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {
    private List<Plants> datalist;
    private Context context;

    public PlantAdapter(Context context, List<Plants>datalist){
        this.datalist = datalist;
        this.context = context;

    }

    @NonNull
    @Override
    public PlantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlantAdapter.ViewHolder holder, int position) {
        Plants data = datalist.get(position);
        holder.nJudul.setText(data.getJudul());
        holder.nDesc.setText(data.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nJudul, nDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nJudul = itemView.findViewById(R.id.tv_judul);
            nDesc =  itemView.findViewById(R.id.tv_deskripsi);
        }
    }
}
