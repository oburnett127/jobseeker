package com.example.jobseeker;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Job.class}, version = 1)
public abstract class JobDatabase extends RoomDatabase {
    private static JobDatabase instance;
    public abstract JobDao JobDao();

    public static synchronized JobDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            JobDatabase.class, "jobseeker").fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(JobDatabase instance) {
            JobDao dao = instance.JobDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}