package com.example.jobseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jobseeker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent listIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.userProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfile();
            }
        });

        binding.jobFeedButton.setOnClickListener(v -> openJobFeed());
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