package com.quick.plantapp.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlantsDao {
    @Query("SELECT * FROM plants")
    List<Plants> getAll();

    @Insert
    void insertAll(Plants plants);

    @Update
    void update(Plants plants);

}
