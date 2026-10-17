package com.domenkoder.helloconstraint;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mShowCount = findViewById(R.id.textView2);
        mButtonZero = findViewById(R.id.button2);

        // Restore count on configuration change (e.g. rotation)
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count", 0);
        }

        updateDisplay();
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    public void zero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        // Return Zero button background color back to gray and disable it
        view.setBackgroundColor(Color.GRAY);
        view.setEnabled(false);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        // Enable Zero button and set active color on Zero button
        if (mButtonZero != null) {
            mButtonZero.setEnabled(true);
            mButtonZero.setBackgroundColor(Color.MAGENTA); // Active color for Zero button
        }

        // Change Count button color depending on whether new value is even or odd (using view parameter, NO findViewById)
        if (mCount % 2 == 0) {
            view.setBackgroundColor(Color.GREEN); // Even (soda)
        } else {
            view.setBackgroundColor(Color.BLUE);  // Odd (liha)
        }
    }

    private void updateDisplay() {
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        if (mButtonZero != null) {
            if (mCount == 0) {
                mButtonZero.setEnabled(false);
                mButtonZero.setBackgroundColor(Color.GRAY); // Gray when count is 0
            } else {
                mButtonZero.setEnabled(true);
                mButtonZero.setBackgroundColor(Color.MAGENTA); // Active when count > 0
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCount);
    }
}
