package com.quick.plantapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quick.plantapp.Adapter.PlantAdapter;
import com.quick.plantapp.R;
import com.quick.plantapp.Room.AppDatabase;
import com.quick.plantapp.Room.Plants;

import java.sql.DataTruncation;

import static com.quick.plantapp.Room.MyApp.db;

public class ViewAct extends AppCompatActivity {
    TextView vJudul, vDesc;
    FloatingActionButton fab_Edit;
    Plants plants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().hide();

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "plants").allowMainThreadQueries().build();

        vJudul = findViewById(R.id.tv_vJudul);
        vDesc = findViewById(R.id.tv_vDesc);
        fab_Edit = findViewById(R.id.fab_edit);

        Intent i = getIntent();
        int id = i.getIntExtra("id", 0);
        String judul = i.getStringExtra("judul");
        String desc = i.getStringExtra("desc");
        fetchData(id, judul, desc);
       ;
    }

    private void fetchData(int id, String judul, String desc) {
        vJudul.setText(judul);
        vDesc.setText(desc);
        edit(id, judul, desc);
    }


    public void edit(final int id, final String judul, final String desc){
        fab_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewAct.this, EditAct.class);
                i.putExtra("id", id);
                i.putExtra("judul", judul);
                i.putExtra("desc", desc);
                startActivity(i);
                finish();
            }
        });
    }
}