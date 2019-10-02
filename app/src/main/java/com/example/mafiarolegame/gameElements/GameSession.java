package com.example.mafiarolegame.gameElements;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class GameSession {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference rootRef = database.getReference();
    private DatabaseReference gameRef;

    private ArrayList<Player> Players = new ArrayList<Player>();
    private String pin;
    private String name;
    private int numberOfPlayers;

    public GameSession(String pin, String name) {
        this.pin = pin;
        this.name = name;
        gameRef = rootRef.child(this.pin);
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
        Player player = new Mafia();
        Players.add(player);
        DatabaseReference testRef = gameRef.child("PLAYA IS HERE YOO");
        testRef.setValue("hello i am playa");
    }
}
