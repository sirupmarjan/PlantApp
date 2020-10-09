package com.quick.plantapp.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Plants.class}, version = 1,  exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PlantsDao plantsDao();
}
