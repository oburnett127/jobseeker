package com.example.jobseeker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jobseeker.databinding.JobFeedBinding;

public class JobRVAdapter extends ListAdapter<Job, JobRVAdapter.ViewHolder> {
    private OnItemClickListener listener;

    JobRVAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Job> DIFF_CALLBACK = new DiffUtil.ItemCallback<Job>() {
        @Override
        public boolean areItemsTheSame(Job oldItem, Job newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Job oldItem, Job newItem) {
            return oldItem.getEmployer().equals(newItem.getEmployer()) &&
                    oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDesc().equals(newItem.getDesc()) &&
                    oldItem.getPostDate().equals(newItem.getPostDate());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Why attachToRoot is false: https://stackoverflow.com/a/45809756
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_feed, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Job job = getJobAt(position);
        holder.jobTitleTV.setText(job.getTitle());
        holder.jobByLineTV.setText(job.getEmployer() + " - " + job.getPostDate());
        holder.jobDescTV.setText(job.getDesc());
    }

    public Job getJobAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView jobTitleTV, jobByLineTV, jobDescTV;
        JobFeedBinding binding;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            jobTitleTV = itemView.findViewById(R.id.title);
            jobByLineTV = itemView.findViewById(R.id.byLine);
            jobDescTV = itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Job model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}