package com.example.jobseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jobseeker.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    private RecyclerView jobsRV;
    private JobRVAdapter jobRVAdapter;
    private JobViewModel jobViewModel;
    private static final int ADD_JOB_REQUEST = 1;
    private static final int EDIT_JOB_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        jobsRV = findViewById(R.id.jobfeedRV);
        jobsRV.setHasFixedSize(true);
        jobsRV.setLayoutManager(new LinearLayoutManager(this));


        jobViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
                .getApplication())
                .create(JobViewModel.class);

        jobViewModel.getAllJobs().observe(this, jobs -> {
            jobRVAdapter = new JobRVAdapter(jobs, MainActivity.this, this);
            jobsRV.setAdapter(jobRVAdapter);
        });

        binding.userProfileButton.setOnClickListener(view -> {
            Intent displayUserProfileIntent = new Intent(this, UserProfileActivity.class);
            startActivity(displayUserProfileIntent);
        });

        binding.jobFeedButton.setOnClickListener(view -> {
            Intent jobFeedIntent = new Intent(this, JobFeedActivity.class);
            startActivity(jobFeedIntent);
        });

        binding.jobAddFab.setOnClickListener(view -> {
            Intent jobAddIntent = new Intent(this, NewJobActivity.class);
            startActivity(jobAddIntent);
        });
    }
}

//        we may need this code in the future
//        //below method is use to add swipe to delete method for item of recycler view.
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                    return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                    // on recycler view item swiped then we are deleting the item of our recycler view.
//                    viewModel.delete(adapter.getJobAt(viewHolder.getAdapterPosition()));
//                    Toast.makeText(MainActivity.this, "Job deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).attachToRecyclerView(jobsRV);


//        adapter.setOnItemClickListener(new JobRVAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Job job) {
//                    Intent intent = new Intent(MainActivity.this, ViewJobActivity.class);
//                    intent.putExtra(ViewJobActivity.JOB_ID, job.getId());
//                    intent.putExtra(ViewJobActivity.JOB_TITLE, job.getTitle());
//                    intent.putExtra(ViewJobActivity.JOB_EMPLOYER, job.getEmployer());
//                    intent.putExtra(ViewJobActivity.JOB_DESC, job.getDesc());
//
//                    startActivityForResult(intent);
//            }
//        });
//    }

//    private void openUserProfile() {
//        listIntent = new Intent(this, UserProfileActivity.class);
//        startActivity(listIntent);
//    }

//    private void openJobFeed(){
//        listIntent = new Intent(this, JobFeedActivity.class);
//        startActivity(listIntent);
//    }
//}