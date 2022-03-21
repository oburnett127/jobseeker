package com.example.jobseeker;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;
import androidx.annotation.NonNull;

@Database(entities = {Job.class}, version = 1)
public abstract class JobDatabase extends RoomDatabase {
    public abstract JobDao jobDao();
}
