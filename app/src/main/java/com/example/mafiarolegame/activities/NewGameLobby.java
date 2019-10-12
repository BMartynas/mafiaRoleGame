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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class NewGameLobby extends AppCompatActivity {
    private DBManager DBM;
    private String gamePinInfo, listOfPlayersDisplay = "";
    private GameSession game;
    private int numberOfPlayers;
    private String allPlayersS;
    private boolean gateOpen; //ar dar galima pereiti i gamesession

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_lobby);

        TextView gamePin = (TextView) findViewById(R.id.game_pin_text);
        final TextView allPlayers = (TextView) findViewById(R.id.listOfPlayers);
        allPlayersS = new String();

        DBM = new DBManager(gamePin.getText().toString());
        gateOpen = true;

        Bundle previousActivityInfo = getIntent().getExtras();
        if (previousActivityInfo != null) {
            gamePinInfo = previousActivityInfo.getString("gamePinInfo");
            gamePin.setText(gamePinInfo);
        }

        DBM.getGameRef().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                game = dataSnapshot.getValue(GameSession.class);
                //game.getNumberOfCurrentPlayers();
                Log.v("ROOM", game.getNumberOfCurrentPlayers() + "");
                if (game.checkIfEnoughPlayers() && gateOpen == true) {
                    // GOTO OTHER ACTIVITY
                    gateOpen = false;
                    showRole();
                }

                Log.v("ROOM", "Refilling player list");
                allPlayersS = "";
                for (int i = 0; i < game.getNumberOfCurrentPlayers(); i++) {
                    allPlayersS += game.getPlayerAt(i).getName() + "\n";
                }
                allPlayers.setText(allPlayersS);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("FULLGAME", "NO");
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
        //this.updatePlayers();
    }
    public void updatePlayers() {
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
                game.setNumberOfCurrentPlayers(numberOfPlayers);
                if(game.getPlayers().size() > 1) DBM.updateDB(game);
                if(game.getNumberOfExpectedPlayers() == DBM.getNumberOfPlayers(dataSnapshot)) showRole();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("Error updating names", "wtf");
            }
        });

    }

    public void showRole() {
            assignRoles();
            Intent intent = new Intent(this, CurrentGameScreen.class);
            intent.putExtra("GameSession", game);
            intent.putExtra("playerID", DBM.getPlayerID());
            startActivity(intent);
    }

    public void assignRoles (){
        int mafia = game.getNumberOfMafia();
        int citizens = game.getNumberOfCitizens();
        Random rand = new Random();
        ArrayList<Player> temp = game.getPlayers();
        for (Player p: temp) {
            if(mafia > 0 && citizens > 0) {
                if(rand.nextBoolean() == true){
                    p.setRole("Mafia");
                    mafia--;
                } else {
                    p.setRole("Citizen");
                    citizens--;
                }
            } else if(mafia > 0) {
                p.setRole("Mafia");
                mafia--;
            } else if(citizens > 0) {
                p.setRole("Citizen");
                citizens--;
            } else {

                Log.v("weird", "all roles assigned, loop should be closed");
                break;
            }
        }
        game.setPlayers(temp);
        DBM.getGameRef().setValue(game);
    }

    public GameSession getLatestGameSession() {
        return this.game;
    }
}







//           _
//       ___/ *>
//   ~~~~\____/~~~~~~
//