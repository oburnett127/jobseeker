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
    
    public void insert(Job model) {
        repository.insert(model);
    }
    
    public void update(Job model) {
        repository.update(model);
    }
    
    public void delete(Job model) {
        repository.delete(model);
    }
    
    public LiveData<List<Job>> getAllJobs() {
        return allJobs;
    }
}