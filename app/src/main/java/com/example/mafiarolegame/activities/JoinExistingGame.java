package com.example.mafiarolegame.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.util.Log;

import com.example.mafiarolegame.gameElements.DBManager;
import com.example.mafiarolegame.gameElements.GameSession;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import java.util.Random;

import com.example.mafiarolegame.R;

public class JoinExistingGame extends AppCompatActivity {

    private EditText gamePin;
    private EditText playerName;
    private String playerNameS;
    private Button joinGame;
    private DatabaseReference gameRef;
    private DatabaseReference playerRef;
    private String gamePinS;
    private GameSession game;
    private int rand;
    private DBManager DBM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_existing_game);

        gamePin = (EditText) findViewById(R.id.game_pin_text);
        playerName = (EditText) findViewById(R.id.player_name_text);
        joinGame = (Button) findViewById(R.id.join_game_button);


        joinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openNewGameLobby();
                DBM = new DBManager(gamePin.getText().toString());

                DBM.getGameRef().addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        DBM.createNewPlayer(playerName.getText().toString(), dataSnapshot);
                        game = dataSnapshot.getValue(GameSession.class);


                        openNewGameLobby();
                        Log.v("TAGYEH", "" + dataSnapshot.child("players").getChildrenCount());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.v("TAGYEH", "NO");
                    }
                });
            }
        });
    }

    public void openNewGameLobby() {
        Intent intent = new Intent(this, NewGameLobby.class);
        intent.putExtra("gamePinInfo", gamePin.getText().toString());
        startActivity(intent);
    }
}
