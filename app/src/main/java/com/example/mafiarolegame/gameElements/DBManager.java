package com.example.mafiarolegame.gameElements;

import android.view.View;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

import java.util.Random;

public class DBManager {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference rootRef = database.getReference("/Session ID");
    private DatabaseReference gameRef;
    private DatabaseReference playersRef;
    private DatabaseReference testRef;
    private DatabaseReference playerUniqueRef;

    private int rand;
    private String gamePin;
//    private String playerPin;

    public DBManager(String gamePin) {
        this.gamePin = gamePin;
        gameRef = rootRef.child(gamePin);

    }

    public void createNewGame(GameSession game, String nick) {
        //gameRef = rootRef.child(game.getPin());

//        ArrayList<Player> someL = new ArrayList<>();
//        someL.add(new Player("one", "01"));
//        someL.add(new Player("two", "02"));
        gameRef.setValue(game);
        playersRef = gameRef.child("players");
        playerUniqueRef = playersRef.child("0");
        playerUniqueRef.setValue(new Player(nick, "0"));

//        game.addPlayerToList(new Player("Kom", "0")))
//        playerUniqueRef = gameRef.child("players").child("0");
//
//        playerUniqueRef.setValue(new Player("JOsh", "00"));
        //gameRef.child("players").setValue("test");
        //playersRef = gameRef.child("players");
        //playersRef.setValue("test");
        //return game.getPin();
    }

    public void createNewPlayer(String name, DataSnapshot ds) {
        //rand = new Random().nextInt(1000000);
        playersRef = gameRef.child("players");
        playerUniqueRef = playersRef.child("" + ds.child("players").getChildrenCount());
        playerUniqueRef.setValue(new Player(name, "" + ds.child("players").getChildrenCount()));
    }

    public DatabaseReference getGameRef() {
        return gameRef;
    }

}
