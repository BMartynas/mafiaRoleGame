package com.example.mafiarolegame.activities;

import android.content.Context;
import android.content.Intent;

import com.example.mafiarolegame.gameElements.DBManager;
import com.example.mafiarolegame.gameElements.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

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
    private int numberOfMafia;
    private int numberOfCitizens;
    private HashMap<String, Integer> votingResults = new HashMap<String, Integer>();

    public HashMap<String, Integer> getVotingResults() {
        return votingResults;
    }

    public void setVotingResults(HashMap<String, Integer> votingResults) {
        this.votingResults = votingResults;
    }
//private int numberOfPlayers;
    //private Player players;

    public GameSession() {

    }

    public GameSession(String pin, String name,int numberOfMafia, int numberOfCitizens) {
        this.pin = pin;
        this.name = name;

        this.numberOfMafia = numberOfMafia;
        this.numberOfCitizens = numberOfCitizens;
        this.numberOfCurrentPlayers = 0;
        this.numberOfCurrentPlayers = 1;
//        this.numberOfExpectedPlayers = 4; // veliau atkeisti i line po apacia
        this.numberOfExpectedPlayers = numberOfCitizens + numberOfMafia;


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

    public int getNumberOfMafia() {
        return numberOfMafia;
    }

    public void setNumberOfMafia(int numberOfMafia) {
        this.numberOfMafia = numberOfMafia;
    }

    public int getNumberOfCitizens() {
        return numberOfCitizens;
    }

    public void setNumberOfCitizens(int numberOfCitizens) {
        this.numberOfCitizens = numberOfCitizens;
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

    public void addVote(String name) {
        int currentVotes = 0;
        if (votingResults.containsKey(name)) {
            currentVotes = this.votingResults.get(name);
        }
        votingResults.put(name, currentVotes + 1);
    }

    public String obtainVotingResults() {
        int maxVotes = Collections.max(votingResults.values());

        List<String> playersWithMaxVotes = new ArrayList<String>();
        for (Entry<String, Integer> player : votingResults.entrySet()) {
            if (player.getValue() == maxVotes) {
                playersWithMaxVotes.add(player.getKey());
            }
        }


        if (playersWithMaxVotes.size() == 1) {
            return playersWithMaxVotes.get(0);
        }

        //if tied
        int howManyTied = playersWithMaxVotes.size();
        int randomPlayerIndex = new Random().nextInt(howManyTied);
        return playersWithMaxVotes.get(randomPlayerIndex);
    }
}
