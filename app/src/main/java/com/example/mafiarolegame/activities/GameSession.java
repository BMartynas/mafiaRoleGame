package com.example.mafiarolegame.activities;

import android.content.Context;
import android.content.Intent;

import com.example.mafiarolegame.gameElements.DBManager;
import com.example.mafiarolegame.gameElements.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class GameSession implements Serializable {
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
    private int numberOfCurrentPlayers;
    private int numberOfExpectedPlayers;


    //private int numberOfPlayers;
    //private Player players;

    public GameSession() {

    }

    public GameSession(String pin, String name, int numberOfCurrentPlayers, int numberOfExpectedPlayers) {
        this.pin = pin;
        this.name = name;
        this.numberOfCurrentPlayers = numberOfCurrentPlayers;
        this.numberOfExpectedPlayers = 4; // veliau atkeisti i line po apacia
        //this.numberOfExpectedPlayers = numberOfExpectedPlayers;


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

    public int getNumberOfCurrentPlayers() {
        return numberOfCurrentPlayers;
    }

    public void setNumberOfCurrentPlayers(int numberOfCurrentPlayers) {
        this.numberOfCurrentPlayers = numberOfCurrentPlayers;
    }

    public int getNumberOfExpectedPlayers() {
        return numberOfExpectedPlayers;
    }

    public void setNumberOfExpectedPlayers(int numberOfExpectedPlayers) {
        this.numberOfExpectedPlayers = numberOfExpectedPlayers;
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

    public Player getPlayerAt (int id) {
        return players.get(id);
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
        return (this.numberOfCurrentPlayers == this.numberOfExpectedPlayers); // UNCHECKED CODE!!!!!
    }
}
