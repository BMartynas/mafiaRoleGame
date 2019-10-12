package com.example.mafiarolegame.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.mafiarolegame.R;
import com.example.mafiarolegame.gameElements.DBManager;
import com.example.mafiarolegame.gameElements.Player;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CurrentGameScreen extends AppCompatActivity {
    private TextView timeLeftText;
    private TextView timeOfDayText;
    private TextView playerRoleText;
    private GameSession game;
    private int timeLeft = 11;       // test, change later
    private boolean isDay;
    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private MediaPlayer mediaPlayer;
    public int playerID;
    private HashMap<String, Integer> votingResults;
    private DBManager DBM;

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
        Log.v("Session", "role is:" + game.getPlayerAt(playerID).getRole());
        DBM = new DBManager(game.getPin());
        votingResults = new HashMap<String, Integer>();

        keepVotesUpToDate();

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
            timeLeft = 11;       // test, change later
        }
    }

    public void changeTimeOfDay(boolean isDay)
    {
        this.isDay = isDay;
        if (isDay)
        {
            timeOfDayText.setText("Day");
            mediaPlayer = MediaPlayer.create(CurrentGameScreen.this, R.raw.everyone_wake_up);   // galima gaidi
            mediaPlayer.start();
        }
        else
        {
            timeOfDayText.setText("Night");
            mediaPlayer = MediaPlayer.create(CurrentGameScreen.this, R.raw.mafia_wake_up_vote);
            mediaPlayer.start();
        }


        //voting happens here

    }

    public void keepVotesUpToDate() {
        DBM.getVotesRef().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                votingResults = dataSnapshot.child("votingResults").getValue(HashMap<String, Integer>);
                votingResults.clear();

                for (DataSnapshot voteSS: dataSnapshot.getChildren()) {
                    int votes = voteSS.getValue(int.class);
                    votingResults.put(voteSS.getKey(), votes);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
