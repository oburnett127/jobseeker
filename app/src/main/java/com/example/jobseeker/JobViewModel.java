package com.example.jobseeker;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class JobViewModel extends AndroidViewModel {
    private JobRepository repository;
    
    private LiveData<List<Job>> allJobs;
    
    public JobViewModel(@NonNull Application application) {
        super(application);
        repository = new JobRepository(application);
        allJobs = repository.getAllJobs();
    }
    
    public void insert(Job job) {
        repository.insert(job);
    }

    public LiveData<Job> get(int id) { return repository.get(id);}

    public LiveData<List<Job>> getAllJobs() {
        return allJobs;
    }
    
    public void update(Job job) {
        repository.update(job);
    }
    
    public void delete(Job job) {
        repository.delete(job);
    }
}