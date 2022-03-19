package com.example.jobseeker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobseeker.databinding.JobCardBinding;

public class JobAdapter extends RecyclerView.Adapter<JobViewHolder> {
    private final LayoutInflater inflater;
    private final Job[] jobPosts;

    JobAdapter(LayoutInflater inflater, Job[] jobPosts){
        this.inflater = inflater;
        this.jobPosts = jobPosts;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // why attachToRoot is false: https://stackoverflow.com/a/45809756
        JobCardBinding binding = JobCardBinding.inflate(inflater, parent, false);

        return new JobViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int index) {
        // populate JobCard with data
        holder.bindTo(jobPosts[index]);
    }


    @Override
    // RecyclerView uses this to determine when there are no more items that can be displayed.
    public int getItemCount() {
        return jobPosts.length;
    }
}
