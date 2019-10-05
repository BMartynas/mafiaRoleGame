package com.example.mafiarolegame.gameElements;

import androidx.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

import java.util.Random;

public class DBManager {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference rootRef = database.getReference("/Session ID");
    private DatabaseReference gameRef;
    private DatabaseReference playersRef;
    private DatabaseReference testRef;

    private int rand;
    private String gamePin;
//    private String playerPin;

    public DBManager(String gamePin) {
        this.gamePin = gamePin;
        gameRef = rootRef.child(gamePin);
    }

    public String createNewGame(GameSession game) {
        gameRef = rootRef.child(game.getPin());
        gameRef.setValue(game);
        playersRef = gameRef.child("players");
        playersRef.setValue("test");
        return game.getPin();
    }

    public String createNewPlayer(String name) {
        rand = new Random().nextInt(1000000);
        playersRef = gameRef.child("players");
        DatabaseReference playerUniqueRef = playersRef.child(rand + "");
        playerUniqueRef.setValue(name);
        return rand + "";
    }

}
