package com.example.jobseeker;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jobseeker.databinding.JobFeedBinding;

import java.util.Arrays;

public class JobFeedActivity extends AppCompatActivity {

    private final int NUM_OF_POSTS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTitle("Job Feed");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final JobFeedBinding binding = JobFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Job[] jobs = getJobs(NUM_OF_POSTS);

        Log.d("job array", Arrays.toString(jobs));

        JobAdapter adapter = new JobAdapter(getLayoutInflater(), jobs);

        binding.jobfeed.setLayoutManager(new LinearLayoutManager(this));
        binding.jobfeed.setAdapter(adapter);

    }

    private Job[] getJobs(int numOfJobs){
        Job[] jobs = new Job[numOfJobs];

        for(int i=0; i<jobs.length; i++){
            jobs[i] = generateFakeJob(i);
        }

        return jobs;
    }

    private Job generateFakeJob(int index){
        String emp = "Employer #" + index;
        String title = "Sample Job Title #" + index;
        String desc = "Job Desc #" + index + "\n- Duties: lorem ipsum\n- Pay: $100,000\n- Requirements: lorem ipsum";
        String date = "01/01/2001";
        Job j = new Job(emp, title, desc, date);
        Log.d("job", j.toString());
        return j;
    }
}
