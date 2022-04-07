package com.example.jobseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jobseeker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    protected static JobViewModel jobViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        jobViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
                .getApplication())
                .create(JobViewModel.class);

//        jobViewModel.getAllJobs().observe(this, jobs -> {
//            jobRVAdapter = new JobRVAdapter(jobs, MainActivity.this, this);
//            jobsRV.setAdapter(jobRVAdapter);
//        });

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

//        *** we may need this code in the future ***
//
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

//    private void openUserProfile() {
//        listIntent = new Intent(this, UserProfileActivity.class);
//        startActivity(listIntent);
//    }

//    private void openJobFeed(){
//        listIntent = new Intent(this, JobFeedActivity.class);
//        startActivity(listIntent);
//    }
//}