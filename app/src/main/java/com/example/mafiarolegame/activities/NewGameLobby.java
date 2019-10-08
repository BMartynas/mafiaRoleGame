package com.example.mafiarolegame.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mafiarolegame.R;
import com.example.mafiarolegame.gameElements.DBManager;
import com.example.mafiarolegame.gameElements.Player;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class NewGameLobby extends AppCompatActivity {
    private DBManager DBM;
    private String gamePinInfo, listOfPlayersDisplay = "";
    private GameSession game;
    private int numberOfPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_lobby);
        TextView gamePin = (TextView) findViewById(R.id.game_pin_text);


        Bundle previousActivityInfo = getIntent().getExtras();
        if (previousActivityInfo != null) {
            gamePinInfo = previousActivityInfo.getString("gamePinInfo");
            gamePin.setText(gamePinInfo);
        }

        DBM = new DBManager(gamePinInfo);
        DBM.getGameRef().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              game = dataSnapshot.getValue(GameSession.class);
              for (Player player : game.getPlayers()) {
                  listOfPlayersDisplay = player.getName() + "\n" + listOfPlayersDisplay;
              }
                TextView listOfPlayers = (TextView) findViewById(R.id.listOfPlayers);

                listOfPlayers.setText(listOfPlayersDisplay);
                numberOfPlayers = game.getPlayers().size();
                game.setNumberOfPlayers(numberOfPlayers);
                if(game.getPlayers().size() > 1) DBM.updateDB();
                if(game.getNumberOfRoles() == DBM.getNumberOfPlayers(dataSnapshot)) showRole();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("Error updating names", "wtf");
            }
        });


//        gamePin.setText(game.get);
    }

        public void showRole() {
            Intent intent = new Intent(this, ShowRole.class);
            startActivity(intent);
    }
}
