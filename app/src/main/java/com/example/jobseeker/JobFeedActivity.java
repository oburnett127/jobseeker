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

    //private final int NUM_OF_POSTS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTitle("Job Feed");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final JobFeedBinding binding = JobFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Job[] jobs = getJobs(NUM_OF_POSTS);

        JobRVAdapter adapter = new JobRVAdapter();

        binding.jobfeed.setLayoutManager(new LinearLayoutManager(this));
        binding.jobfeed.setAdapter(adapter);

    }

    // TODO remove or modify these two methods after job CRUD is implemented
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

        return new Job(index, emp, title, desc, date);
    }
}

//Not sure where below code should go yet. Temporarily placing it below.
//        // setting layout manager to our adapter class.
//        jobsRV.setLayoutManager(new LayoutManager(this));
//        jobsRV.setHasFixedSize(true);
//
//        // initializing adapter for recycler view.
//        final JobRVAdapter adapter = new JobRVAdapter();
//
//        // setting adapter class for recycler view.
//        jobsRV.setAdapter(adapter);
//
//        // passing a data from view Model.
//        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
//
//        // below line is use to get all the jobs from view Model.
//        viewModel.getAllJobs().observe(this, new Observer<List<Job>>() {
//            @Override
//            public void onChanged(List<Job> models) {
//                    // when the data is changed in our models we are
//                    // adding that list to our adapter class.
//                    adapter.submitList(models);
//                    }
//        });
//
//        // below method is use to add swipe to delete method for item of recycler view.
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
//
//        adapter.setOnItemClickListener(new JobRVAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Job model) {
//                    // after clicking on item of recycler view
//                    // we are opening a new activity and passing
//                    // a data to our activity.
//                    Intent intent = new Intent(MainActivity.this, NewJobActivity.class);
//                    intent.putExtra(NewJobActivity.EXTRA_ID, model.getId());
//                    intent.putExtra(NewJobActivity.EXTRA_JOB_NAME, model.getJobName());
//                    intent.putExtra(NewJobActivity.EXTRA_DESCRIPTION, model.getJobDescription());
//                    intent.putExtra(NewJobActivity.EXTRA_DURATION, model.getJobDuration());
//
//                    // below line is to start a new activity and
//                    // adding a edit job constant.
//                    startActivityForResult(intent, EDIT_JOB_REQUEST);
//            }
//        });