package com.example.mafiarolegame.activities;

import android.content.Context;
import android.content.Intent;

import com.example.mafiarolegame.gameElements.Player;

import java.util.ArrayList;

public class GameSession {
//    private FirebaseDatabase database = FirebaseDatabase.getInstance();
//    private DatabaseReference rootRef = database.getReference("/Session ID");
//    private DatabaseReference gameRef;
//    private DatabaseReference playersRef;
//    private DatabaseReference testRef;
//    private int rand;

//    private DBManager DBM;
    private String pin;
    private String name;
    private ArrayList<Player> players;
    private int numberOfPlayers;
    private int numberOfRoles;


    //private int numberOfPlayers;
    //private Player players;

    // Don't touch this, srsly
    public GameSession() {

    }

    public GameSession(String pin, String name, int numberOfPlayers, int numberOfRoles) {
        this.pin = pin;
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfRoles = numberOfRoles;
//        players = new ArrayList<Player>();

//        DBM = new DBManager(pin);

//        gameRef = rootRef.child(this.pin);
//        gameRef.setValue(this);
//        playersRef = gameRef.child("players");

    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getNumberOfRoles() {
        return numberOfRoles;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

//    public GameSession getGameSession() {
//        return this;
//    }

    public ArrayList<Player> addPlayerToList(Player p) {

        players.add(p);
        return players;
    }

//    public void addPlayer() {
////        rand = new Random().nextInt(1000000);
////        Mafia playerObj = new Mafia("test");
////        Players.add(playerObj);
//        //gameRef.setValue(this);
////        testRef = playersRef.child("" + rand);
////        testRef.setValue(playerObj);
//    }

    public boolean checkIfEnoughPlayers() {
        return this.numberOfRoles == this.numberOfPlayers;
    }
}
