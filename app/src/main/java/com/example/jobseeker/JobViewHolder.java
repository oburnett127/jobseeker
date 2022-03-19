package com.example.jobseeker;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jobseeker.databinding.JobCardBinding;

public class JobViewHolder extends RecyclerView.ViewHolder{
    private final JobCardBinding binding;

    JobViewHolder(JobCardBinding binding){
        super(binding.getRoot());

        this.binding = binding;

        // TODO: Put logic for job card buttons here
    }

    void bindTo(Job job){
        Context ctx = binding.title.getContext();
        binding.title
                .setText(ctx.getString(R.string.jc_title, job.getTitle()));
        binding.byLine
                .setText(ctx.getString(R.string.jc_by_line, job.getEmployer(), job.getPostDate()));
        binding.desc
                .setText(ctx.getString(R.string.jc_desc, job.getDesc()));
    }
}
