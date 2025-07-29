package com.cst338.gymlog;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cst338.gymlog.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DAC_GYMLOG";
    ActivityMainBinding binding;
    String mExcercise = "";
    double mWeight = 0.0;
    int mReps = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.logDisplayTextView.setMovementMethod(new ScrollingMovementMethod());

        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                updateDisplay();
            }
        });
    }

    private void updateDisplay(){
        String currentInfo = binding.logDisplayTextView.getText().toString();
        Log.d(TAG,"Current display info: " + currentInfo);
        String newDisplay = String.format(Locale.US,"Exercise: %s%nWeight:%.2f%nReps:%d%n=-=-=-=%n%s", mExcercise, mWeight, mReps, currentInfo);
        binding.logDisplayTextView.setText(newDisplay);


    }
    private void getInformationFromDisplay(){
        mExcercise = binding.exerciseInputEditText.getText().toString();
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