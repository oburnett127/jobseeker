package com.example.jobseeker;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jobseeker.databinding.ActivityJobDisplayBinding;

public class JobDisplayActivity extends AppCompatActivity {

    private ActivityJobDisplayBinding binding;
    private String JOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityJobDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        JOB = savedInstanceState.getString(JOB);


    }
}
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_job_display);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_job_display);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}