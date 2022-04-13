package com.example.jobseeker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;

public class JobRVAdapter extends RecyclerView.Adapter<JobRVAdapter.ViewHolder> {
    private final List<Job> jobList;
    private final Context context;
    private final OnJobClickListener jobClickListener;

    public JobRVAdapter(List<Job> jobList, Context context, OnJobClickListener onJobClickListener) {
        this.jobList = jobList;
        this.context = context;
        this.jobClickListener = onJobClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Why attachToRoot is false: https://stackoverflow.com/a/45809756
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_job_feed, parent, false);
        return new ViewHolder(view, jobClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Job job = Objects.requireNonNull(jobList.get(position));
    }

    @Override
    public int getItemCount()  {
        return Objects.requireNonNull(jobList.size());
    }

    public interface OnJobClickListener {
        void onJobClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView jobTitleTV, jobByLineTV, jobDescTV;
        OnJobClickListener onJobClickListener;

        public ViewHolder(@NonNull View itemView, OnJobClickListener onJobClickListener) {
            super(itemView);
            jobTitleTV = itemView.findViewById(R.id.title);
            jobByLineTV = itemView.findViewById(R.id.byLine);
            jobDescTV = itemView.findViewById(R.id.desc);
            this.onJobClickListener = onJobClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onJobClickListener.onJobClick(getAdapterPosition());
        }
    }
}