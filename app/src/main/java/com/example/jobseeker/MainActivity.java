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
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jobseeker.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    private Intent listIntent;
    private RecyclerView jobsRV;
    private static final int ADD_JOB_REQUEST = 1;
    private static final int EDIT_JOB_REQUEST = 2;
    private ViewModel viewmMdel;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        FloatingActionButton fab = binding.idFABAdd;

        binding.userProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfile();
            }
        });

        // open jobs feed page once user clicks jobFeed button
        binding.jobFeedButton.setOnClickListener(v -> openJobFeed());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting a new activity for adding a new job
                // and passing a constant value in it.
                Intent intent = new Intent(MainActivity.this, NewJobActivity.class);
                startActivityForResult(intent, ADD_JOB_REQUEST);
            }
        });
    }

    private void openUserProfile() {
        listIntent = new Intent(this, UserProfileActivity.class);
        startActivity(listIntent);
    }

    private void openJobFeed(){
        listIntent = new Intent(this, JobFeedActivity.class);
        startActivity(listIntent);
    }
}