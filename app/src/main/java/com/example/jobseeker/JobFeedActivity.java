package com.example.jobseeker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobseeker.databinding.JobFeedBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class JobFeedActivity extends AppCompatActivity implements JobRVAdapter.OnJobClickListener {
    private static final String TAG = "Clicked";
    public static final String JOB_ID = "job_id";
    private JobViewModel jobViewModel;
    private TextView textView;
    private RecyclerView recyclerView;
    private JobRVAdapter recyclerViewAdapter;
    private LiveData<List<Job>> jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_feed);
        recyclerView = findViewById(R.id.jobfeedRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jobViewModel = new ViewModelProvider.AndroidViewModelFactory(JobFeedActivity.this
                .getApplication()
                .create(JobViewModel.class);

        jobViewModel.getAllJobs().observe(this, jobs -> {
            recyclerViewAdapter = new JobRVAdapter(jobs, JobFeedActivity.this, this);
            recyclerView.setAdapter(recyclerViewAdapter);
        });
    }

    @Override
    public void onJobClick(int position) {
        Job job = Objects.requireNonNull(jobViewModel.allJobs.getValue()).get(position);
        Log.d(TAG, "onJobClick: " + job.getId());

        Intent intent = new Intent(MainActivity.this, NewJob.class);
        intent.putExtra(JOB_ID, job.getId());
        startActivity(intent);
    }
}