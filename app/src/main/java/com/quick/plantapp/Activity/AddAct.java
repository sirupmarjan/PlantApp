package com.quick.plantapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.quick.plantapp.R;
import com.quick.plantapp.Room.Plants;

import static com.quick.plantapp.Room.MyApp.db;

public class AddAct extends AppCompatActivity {
    EditText et_judul, et_deskripsi;
    FloatingActionButton fab_save;
    Plants plants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_judul = findViewById(R.id.et_judul);
        et_deskripsi = findViewById(R.id.et_deskripsi);
        fab_save = findViewById(R.id.fab_save);

        onSaveInput();
    }

    private void onSaveInput() {
        fab_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_judul.getText().toString().isEmpty()&&!et_deskripsi.getText().toString().isEmpty()){
                    plants = new Plants();
                    plants.setJudul(et_judul.getText().toString());
                    plants.setDeskripsi(et_deskripsi.getText().toString());

                    db.plantsDao().insertAll(plants);
                    startActivity(new Intent(AddAct.this, MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}