package com.example.jobseeker;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class JobRepository {
    private JobDao jobDao;
    private LiveData<List<Job>> allJobs;

    public JobRepository(Application application) {
        JobDatabase database = JobDatabase.getInstance(application);
        jobDao = database.JobDao();
        allJobs = jobDao.getAll();
    }

    public void insert(Job job) {
        new InsertJobAsyncTask(jobDao).execute(job);
    }

    public void update(Job job) {
        new UpdateJobAsyncTask(jobDao).execute(job);
    }

    public void delete(Job job) {
        new DeleteJobAsyncTask(jobDao).execute(job);
    }

    public LiveData<List<Job>> getAllJobs() {
        return allJobs;
    }

    private static class InsertJobAsyncTask extends AsyncTask<Job, Void, Void> {
        private JobDao jobDao;

        private InsertJobAsyncTask(JobDao jobDao) {
            this.jobDao = jobDao;
        }

        @Override
        protected Void doInBackground(Job... job) {
            jobDao.insertAll(job[0]);
            return null;
        }
    }

    private static class UpdateJobAsyncTask extends AsyncTask<Job, Void, Void> {
        private JobDao jobDao;

        private UpdateJobAsyncTask(JobDao jobDao) {
            this.jobDao = jobDao;
        }

        @Override
        protected Void doInBackground(Job... jobs) {
            jobDao.updateAll(jobs[0]);
            return null;
        }
    }

    private static class DeleteJobAsyncTask extends AsyncTask<Job, Void, Void> {
        private JobDao jobDao;

        private DeleteJobAsyncTask(JobDao jobDao) {
            this.jobDao = jobDao;
        }

        @Override
        protected Void doInBackground(Job... jobs) {
            jobDao.delete(jobs[0]);
            return null;
        }
    }
}