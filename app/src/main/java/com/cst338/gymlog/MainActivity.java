/**
 * gymlog (the 8 hours of videos to watch assignment)
 *
 * @author Savannah Kestral | lynx
 * @since 7/28/25
 */
//
//         `\.      ,/'
//          |\\____//|
//          )/_ `' _\(
//         ,'/-`__'-\`\
//        /.  (_><_)  ,\
//        `  )/`--'\(` '
//           `      '
//       _
//      | |
//      | |_   _ _ __ __  __
//      | | | | | '_ \\ \/ /
//      | | |_| | | | |>  <
//      |_|\__, |_| |_/_/\_\
//          __/ |
//         |___/
//


package com.cst338.gymlog;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cst338.gymlog.database.GymLogRepository;
import com.cst338.gymlog.database.entities.GymLog;
import com.cst338.gymlog.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "DAC_GYMLOG";
    private ActivityMainBinding binding;
    private GymLogRepository repository;
    String mExercise = "";
    double mWeight = 0.0;
    int mReps = 0;
    int loggedInUserId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = GymLogRepository.getRepository(getApplication());

        binding.logDisplayTextView.setMovementMethod(new ScrollingMovementMethod());
        updateDisplay();

        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                insertGymlogRecord();
                updateDisplay();
            }
        });
    }



    private void insertGymlogRecord() {
        if (mExercise.isEmpty()) {
            return;
        }

        GymLog log = new GymLog(mExercise, mWeight, mReps);
        repository.insertGymLog(log);

    }

    private void updateDisplay(){
        ArrayList<GymLog> allLogs = repository.getAllLogs();
        if (allLogs.isEmpty()) {
            Log.d(TAG, "No logs found in the database.");
            binding.logDisplayTextView.setText(R.string.nothing_to_show_time_to_hit_the_gym);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (GymLog log : allLogs) {
            sb.append(log);
        }
        binding .logDisplayTextView.setText(sb.toString());
    }
    private void getInformationFromDisplay(){
        mExercise = binding.exerciseInputEditText.getText().toString();
        try{
            mWeight = Double.parseDouble(binding.weightInputEditText.getText().toString());
        }catch(NumberFormatException e){
            Log.d(TAG, "Error reading value from Weight edit text: " + e.getMessage());
        }

        try{
            mReps = Integer.parseInt(binding.repInputEditText.getText().toString());
        }catch(NumberFormatException e){
            Log.d(TAG, "Error reading value from reps edit text: " + e.getMessage());
        }


    }
}