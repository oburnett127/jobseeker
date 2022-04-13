package com.example.jobseeker;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Job.class}, version = 1, exportSchema = false)
public abstract class JobDatabase extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile JobDatabase INSTANCE;
    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
//make sure table structure gets fully created
//find out how to associate table structures to a database
                    //may not have any tables inside so it closes the connection
                    databaseWriteExecutor.execute(() -> {
                        JobDao jobDao = INSTANCE.jobDao();

                        Job job = new Job(1, "New Technology Explorers", "Software Developer",
                                                "We need someone who can build software from the ground up. " +
                                                    "The right candidate must have backend, frontend and cloud " +
                                                    "provider experience.",
                                                    "20220301");
                        jobDao.insertAll(job);

                        job = new Job(2, "Software Innovations Corp", "Software Engineer",
                                            "Our next Software Engineer must have extensive hands on " +
                                                    "experience with implementing software using industry " +
                                                    "standard design patterns.",
                                                    "20220302");
                        jobDao.insertAll(job);

                        job = new Job(3, "Web Developers On Call", "Web Developer I",
                                                "This is an entry level web development position. No experience " +
                                                      "necessary. We will provide a laptop. $3000 sign on bonus. " +
                                                        "You must know how to operate a computer.",
                                                "20220303");
                        jobDao.insertAll(job);


                    });
                }
            };

    public static JobDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (JobDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            JobDatabase.class, "job_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract JobDao jobDao();
}