package com.quick.plantapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quick.plantapp.Adapter.PlantAdapter;
import com.quick.plantapp.R;

public class ViewAct extends AppCompatActivity {
    TextView vJudul, vDesc;
    FloatingActionButton fab_Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().hide();
        
        vJudul = findViewById(R.id.tv_vJudul);
        vDesc = findViewById(R.id.tv_vDesc);
        fab_Edit = findViewById(R.id.fab_edit);

        Intent i = getIntent();
        String judul = i.getStringExtra("judul");
        String desc = i.getStringExtra("desc");
        fetchData(judul, desc);
    }

    public void fetchData(String judul, String desc) {
        vJudul.setText(judul);
        vDesc.setText(desc);
    }
}