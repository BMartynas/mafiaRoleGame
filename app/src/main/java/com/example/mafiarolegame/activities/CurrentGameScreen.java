package com.example.mafiarolegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mafiarolegame.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CurrentGameScreen extends AppCompatActivity {
    private TextView timeLeftText;
    private TextView timeOfDayText;
    private int timeLeft = 5;       // test, change later
    private boolean isDay;
    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game_screen);

        timeLeftText = findViewById(R.id.timeLeftText);
        timeOfDayText = findViewById(R.id.timeOfDayText);
        setTimeOfDay(true);
        startCountdown();
    }

    public void startCountdown()
    {
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                countdown();
            }
            }, 0, 1, TimeUnit.SECONDS);
    }

    public void countdown()
    {
        timeLeft--;
        timeLeftText.setText(Integer.toString(timeLeft));
        if (timeLeft == 0)
        {
            setTimeOfDay(!isDay);
            timeLeft = 6;       // test, change later
        }
    }

    public void setTimeOfDay(boolean isDay)
    {
        this.isDay = isDay;
        if (isDay)
        {
            timeOfDayText.setText("Day");
        }
        else
        {
            timeOfDayText.setText("Night");
        }
    }
}
