package com.quick.plantapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quick.plantapp.Adapter.PlantAdapter;
import com.quick.plantapp.R;
import com.quick.plantapp.Room.AppDatabase;
import com.quick.plantapp.Room.Plants;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.quick.plantapp.Room.MyApp.db;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView rv_list;
    FloatingActionButton fab_add;

    PlantAdapter mAdapter;
    List<Plants> datalist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        rv_list = findViewById(R.id.rv_list);
        fab_add = (FloatingActionButton) findViewById(R.id.fab_add);

        fetchData();
        initRv();
        addPlant();
    }

    private void addPlant() {
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddAct.class));
            }
        });
    }

    private void fetchData() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "plants").allowMainThreadQueries().build();
        datalist = db.plantsDao().getAll();

        for (int i = 0; i < datalist.size(); i++ ){
            Log.e(TAG, datalist.get(i).getJudul()+i);
            Log.e(TAG, datalist.get(i).getDeskripsi()+i);
        }
    }

    private void initRv(){
        rv_list.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_list.setLayoutManager(linearLayoutManager);
        mAdapter = new PlantAdapter(this, datalist);

        rv_list.setAdapter(mAdapter);
    }

    public void onBackPressed(){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Exit App?")
                .setConfirmText("Yes")
                .setCancelText("No")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        finish();
                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.cancel();
                    }
                })
                .show();

    }
}