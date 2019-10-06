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
import java.util.List;
import java.util.Random;
import android.util.Log;

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

    //private int numberOfPlayers;
    //private Player players;

    // Don't touch this, srsly
    public GameSession() {

    }

    public GameSession(String pin, String name) {
        this.pin = pin;
        this.name = name;
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

}
