package com.example.jobseeker;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jobseeker.databinding.JobFeedBinding;

import java.util.Arrays;
import java.util.Random;

public class JobFeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTitle("Job Feed");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final JobFeedBinding binding = JobFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        JobRVAdapter adapter = new JobRVAdapter();

        binding.jobfeed.setLayoutManager(new LinearLayoutManager(this));
        binding.jobfeed.setAdapter(adapter);

    }
}