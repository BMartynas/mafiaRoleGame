package com.example.mafiarolegame.gameElements;

import android.provider.ContactsContract;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;
import android.util.Log;

public class GameSession {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference rootRef = database.getReference("/Session ID");
    private DatabaseReference gameRef;
    private DatabaseReference playersRef;
    private DatabaseReference testRef;
    private int rand;

    private ArrayList<Player> Players = new ArrayList<Player>();
    private String pin;
    private String name;
    private int numberOfPlayers;
    private Player tempPlayer;

    public GameSession(String pin, String name) {
        this.pin = pin;
        this.name = name;
        gameRef = rootRef.child(this.pin);
        gameRef.setValue(this);
        playersRef = gameRef.child("players");



        playersRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.v("TAGYEH", s);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer() {
        rand = new Random().nextInt(1000000);
        Mafia playerObj = new Mafia();
        Players.add(playerObj);
        //gameRef.setValue(this);
        testRef = playersRef.child("" + rand);
        testRef.setValue(playerObj);
    }

}
