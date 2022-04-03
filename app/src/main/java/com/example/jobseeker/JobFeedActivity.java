package com.example.jobseeker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobseeker.databinding.JobFeedBinding;

import java.util.List;
import java.util.Objects;

public class JobFeedActivity extends AppCompatActivity implements JobRVAdapter.OnJobClickListener {
    //private static final String TAG = "Clicked";
    public static final String JOB_ID = "job_id";
    private JobViewModel jobViewModel;
    private TextView textView;
    private RecyclerView jobRV;
    private JobRVAdapter jobRVAdapter;
    private LiveData<List<Job>> jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_feed);
        jobRV = findViewById(R.id.jobfeedRV);
        jobRV.setHasFixedSize(true);
        jobRV.setLayoutManager(new LinearLayoutManager(this));

        jobViewModel = new ViewModelProvider.AndroidViewModelFactory(JobFeedActivity.this
                .getApplication())
                .create(JobViewModel.class);

        jobViewModel.getAllJobs().observe(this, jobs -> {
            jobRVAdapter = new JobRVAdapter(jobs, JobFeedActivity.this, this);
            jobRV.setAdapter(jobRVAdapter)
                .setOnItemClickListener(new JobRVAdapter.OnItemClickListener() {
                    @Override
                    public void onJobFeedItemClick(Job job) {
                            Intent intent = new Intent(JobFeedActivity.this, JobDisplayActivity.class);
                            intent.putExtra(JobDisplayActivity., job.getId());
                            intent.putExtra(JobDisplayActivity.JOB_TITLE, job.getTitle());
                            intent.putExtra(JobDisplayActivity.JOB_EMPLOYER, job.getEmployer());
                            intent.putExtra(JobDisplayActivity.JOB_DESC, job.getDesc());
                            startActivityForResult(intent);
                    }
                });
    }

//    @Override
//    public void onJobClick(int position) {
//        Job job = Objects.requireNonNull(jobViewModel.getAllJobs().getValue()).get(position);
//        //Log.d(TAG, "onJobClick: " + job.getId());
//
//        Intent intent = new Intent(MainActivity.this, JobDisplayActivity.class);
//        intent.putExtra(JOB_ID, job.getId());
//        startActivity(intent);
    }
}