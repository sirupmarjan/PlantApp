package com.quick.plantapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quick.plantapp.R;
import com.quick.plantapp.Room.Plants;

import static com.quick.plantapp.Room.MyApp.db;

public class EditAct extends AppCompatActivity {
    EditText eJudul, eDesc;
    FloatingActionButton fab_saveEdit;
    Plants plants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        eJudul = findViewById(R.id.et_eJudul);
        eDesc = findViewById(R.id.et_eDeskripsi);
        fab_saveEdit = findViewById(R.id.fab_saveEdit);

        Intent i = getIntent();
        int id = i.getIntExtra("id", 0);
        String judul = i.getStringExtra("judul");
        String desc = i.getStringExtra("desc");
         onEdit(id, judul, desc);
    }

    private void onEdit(final int id, String judul, String desc) {
        eJudul.setText(judul);
        eDesc.setText(desc);

        fab_saveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInput(id);
            }
        });
    }

    private void saveInput(int id) {
        if (!eJudul.getText().toString().isEmpty()&&!eDesc.getText().toString().isEmpty()){
            plants = new Plants();
            plants.setId(id);
            plants.setJudul(eJudul.getText().toString());
            plants.setDeskripsi(eDesc.getText().toString());

            db.plantsDao().update(plants);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_SHORT).show();
        }
    }
}