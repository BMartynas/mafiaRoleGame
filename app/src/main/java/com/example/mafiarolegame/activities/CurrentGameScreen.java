package com.example.mafiarolegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.mafiarolegame.R;
import com.example.mafiarolegame.gameElements.Player;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CurrentGameScreen extends AppCompatActivity {
    private TextView timeLeftText;
    private TextView timeOfDayText;
    private TextView playerRoleText;
    private GameSession game;
    private int timeLeft = 5;       // test, change later
    private boolean isDay;
    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private MediaPlayer mediaPlayer;
    public int playerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game_screen);

        timeLeftText = findViewById(R.id.timeLeftText);
        timeOfDayText = findViewById(R.id.timeOfDayText);
        playerRoleText = findViewById(R.id.yourRoleText);

        Intent intent = getIntent();
        game = (GameSession)intent.getSerializableExtra("GameSession");
        playerID = (int)intent.getIntExtra("playerID", playerID);
        playerRoleText.setText(game.getPlayerAt(playerID).getRole());

        int numberOfButtons = 6;
        Button buttons[] = new Button[numberOfButtons];
        buttons[0] = findViewById(R.id.name0);
        buttons[1] = findViewById(R.id.name1);
        buttons[2] = findViewById(R.id.name2);
        buttons[3] = findViewById(R.id.name3);
        buttons[4] = findViewById(R.id.name4);
        buttons[5] = findViewById(R.id.name5);

        ArrayList<Player> currentPlayers = game.getPlayers();
        for (int i = 0; i < numberOfButtons; i++) {
            if (i < currentPlayers.size()) {
                buttons[i].setText(currentPlayers.get(i).getName());
            } else {
                buttons[i].setVisibility(TextView.GONE);
            }

        }

        changeTimeOfDay(true);
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
            changeTimeOfDay(!isDay);
            timeLeft = 6;       // test, change later
        }
    }

    public void changeTimeOfDay(boolean isDay)
    {
        this.isDay = isDay;
        if (isDay)
        {
            timeOfDayText.setText("Day");
//            mediaPlayer = MediaPlayer.create(CurrentGameScreen.this, R.raw.everyone_wake_up);   // galima gaidi
//            mediaPlayer.start();
        }
        else
        {
            timeOfDayText.setText("Night");
//            mediaPlayer = MediaPlayer.create(CurrentGameScreen.this, R.raw.mafia_wake_up_vote);
//            mediaPlayer.start();
        }

        //voting happens here

    }
}
