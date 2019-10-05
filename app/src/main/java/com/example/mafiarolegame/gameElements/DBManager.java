package com.example.mafiarolegame.gameElements;

import android.view.View;

import androidx.annotation.NonNull;

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

    public void createNewPlayer(String name, DataSnapshot ds) {
        rand = new Random().nextInt(1000000);
        playersRef = gameRef.child("players");
        DatabaseReference playerUniqueRef = playersRef.child("" + ds.child("players").getChildrenCount());
        playerUniqueRef.setValue(new Player(name, "" + ds.child("players").getChildrenCount()));
    }

    public DatabaseReference getGameRef() {
        return gameRef;
    }

//    public GameSession getGameSession() {
//
//        gameRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        return null;
//    }



}
