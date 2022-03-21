package com.example.jobseeker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewJobActivity extends AppCompatActivity {

    // creating a variables for our button and edittext.
    private EditText jobNameEdt, jobDescEdt, jobDurationEdt;
    private Button jobBtn;

    // creating a constant string variable for our 
    // job name, description and duration.
    public static final String EXTRA_ID = "com.gtappdevelopers.gfgroomdatabase.EXTRA_ID";
    public static final String EXTRA_JOB_NAME = "com.gtappdevelopers.gfgroomdatabase.EXTRA_JOB_NAME";
    public static final String EXTRA_DESCRIPTION = "com.gtappdevelopers.gfgroomdatabase.EXTRA_JOB_DESCRIPTION";
    public static final String EXTRA_DURATION = "com.gtappdevelopers.gfgroomdatabase.EXTRA_JOB_DURATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);

        // initializing our variables for each view.
        jobNameEdt = findViewById(R.id.idEdtJobName);
        jobDescEdt = findViewById(R.id.idEdtJobDescription);
        jobDurationEdt = findViewById(R.id.idEdtJobDuration);
        jobBtn = findViewById(R.id.idBtnSaveJob);

        // below line is to get intent as we
        // are getting data via an intent.
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            // if we get id for our data then we are
            // setting values to our edit text fields.
            jobNameEdt.setText(intent.getStringExtra(EXTRA_JOB_NAME));
            jobDescEdt.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            jobDurationEdt.setText(intent.getStringExtra(EXTRA_DURATION));
        }
        // adding on click listener for our save button.
        jobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting text value from edittext and validating if
                // the text fields are empty or not.
                String jobName = jobNameEdt.getText().toString();
                String jobDesc = jobDescEdt.getText().toString();
                String jobDuration = jobDurationEdt.getText().toString();
                if (jobName.isEmpty() || jobDesc.isEmpty() || jobDuration.isEmpty()) {
                    Toast.makeText(NewJobActivity.this, "Please enter the valid job details.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to save our job.
                saveJob(jobName, jobDesc, jobDuration);
            }
        });
    }

    private void saveJob(String jobName, String jobDescription, String jobDuration) {
        // inside this method we are passing 
        // all the data via an intent.
        Intent data = new Intent();

        // in below line we are passing all our job detail.
        data.putExtra(EXTRA_JOB_NAME, jobName);
        data.putExtra(EXTRA_DESCRIPTION, jobDescription);
        data.putExtra(EXTRA_DURATION, jobDuration);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            // in below line we are passing our id.
            data.putExtra(EXTRA_ID, id);
        }

        // at last we are setting result as data.
        setResult(RESULT_OK, data);

        // displaying a toast message after adding the data
        Toast.makeText(this, "Job has been saved to Room Database. ", Toast.LENGTH_SHORT).show();
    }
}
