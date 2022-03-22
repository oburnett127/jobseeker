package com.example.jobseeker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.jobseeker.databinding.ActivityNewJobBinding;

public class NewJobActivity extends AppCompatActivity {
    protected ActivityNewJobBinding binding;
    private EditText jobTitleEdt, jobByLineEdt, jobDescEdt;
    private Button jobBtn;
    private static final int ADD_JOB_REQUEST = 1;
    private static final int EDIT_JOB_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_job);

        jobTitleEdt = binding.idEdtJobTitle;
        jobByLineEdt = binding.idEdtJobByLine;
        jobDescEdt = binding.idEdtJobDesc
        jobBtn = binding.idBtnSaveJob

        Intent intent = getIntent();

//        if (intent.hasExtra(EXTRA_JOB_ID)) {
//            jobTitleEdt.setText(intent.getStringExtra(EXTRA_JOB_TITLE));
//            jobByLineEdt.setText(intent.getStringExtra(EXTRA_JOB_BYLINE));
//            jobDescEdt.setText(intent.getStringExtra(EXTRA_JOB_DESC));
//        }

        jobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get contents of edit text boxes, validate and call save
            }
        });
    }

//    private void saveJob(String jobTitle, String jobByLine, String jobDesc) {
//        Intent data = new Intent();
//        data.putExtra(EXTRA_JOB_TITLE, jobTitle);
//        data.putExtra(EXTRA_JOB_BYLINE, jobByLine);
//        data.putExtra(EXTRA_JOB_DESC, jobDesc);
//        int id = getIntent().getIntExtra(EXTRA_JOB_ID, -1);
//        if (id != -1) {
//            data.putExtra(EXTRA_JOB_ID, id);
//        }
//
//        setResult(RESULT_OK, data);
//
//        Toast.makeText(this, "Your job has been saved", Toast.LENGTH_SHORT).show();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_JOB_REQUEST && resultCode == RESULT_OK) {
            String employer = data.getStringExtra(binding.idEdtJobTitle.getText().toString());
            String title = data.getStringExtra(binding.idEdtJobTitle.getText().toString());
            String desc = data.getStringExtra(binding.idEdtJobDesc.getText().toString());


            if (employer.isEmpty() || title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(NewJobActivity.this, "You must enter a value in all required fields, marked with an *.", Toast.LENGTH_SHORT).show();
                return;
            }

            Job model = new Job(jobEmployer, jobTitle, jobByLine, jobDesc, jobPostDate);

            viewModel.insert(model);

            Toast.makeText(this, "Job saved", Toast.LENGTH_SHORT).show();

        } else if (requestCode == EDIT_JOB_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(NewJobActivity.EXTRA_ID, -1);
            if (id == -1) {
                Toast.makeText(this, "Job can't be updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String jobTitle = data.getStringExtra(NewJobActivity.EXTRA_JOB_NAME);
            String jobByLine = data.getStringExtra(NewJobActivity.EXTRA_DESCRIPTION);
            String jobDesc = data.getStringExtra(NewJobActivity.EXTRA_DURATION);
            Job model = new Job(jobTitle, jobDesc, jobDesc);
            model.setId(id);
            viewModel.update(model);
            Toast.makeText(this, "Job updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Job not saved", Toast.LENGTH_SHORT).show();
        }
    }
}