package com.example.mafiarolegame.gameElements;

import com.example.mafiarolegame.activities.GameSession;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBManager {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference rootRef = database.getReference("/Session ID");
    private DatabaseReference gameRef;
    private DatabaseReference playersRef;
    private DatabaseReference numberOfCurrentPlayersRef;
    private DatabaseReference numberOfExpectedPlayersRef;
    private DatabaseReference testRef;
    private DatabaseReference playerUniqueRef;
    private GameSession gameSessionRef;
    private int playerID;

    private int rand;
    private String gamePin;
        //    private String playerPin;

    public DBManager(String gamePin) {
        this.gamePin = gamePin;
        gameRef = rootRef.child(gamePin);
        playersRef = gameRef.child("players");
        numberOfCurrentPlayersRef = gameRef.child("numberOfCurrentPlayers");
        numberOfExpectedPlayersRef = gameRef.child("numberOfExpectedPlayers");
    }

    public void createNewGame(GameSession game, String nick) {
        //gameRef = rootRef.child(game.getPin());
        this.gameSessionRef = game;
//        ArrayList<Player> someL = new ArrayList<>();
//        someL.add(new Player("one", "01"));
//        someL.add(new Player("two", "02"));
        gameRef.setValue(game);

        playerUniqueRef = playersRef.child("0");
        playerUniqueRef.setValue(new Player(nick, "0", "Citizen")); //creator'io player'is

//        game.addPlayerToList(new Player("Kom", "0")))
//        playerUniqueRef = gameRef.child("players").child("0");
//
//        playerUniqueRef.setValue(new Player("JOsh", "00"));
        //gameRef.child("players").setValue("test");
        //playersRef = gameRef.child("players");
        //playersRef.setValue("test");
        //return game.getPin();
    }

    public void createNewPlayer(String name, DataSnapshot ds, GameSession game) {

        playerID = ds.child("numberOfCurrentPlayers").getValue(int.class);

        playerUniqueRef = playersRef.child("" + playerID);
//        Player newPlayer = new Player(name, "" + ds.child("numberOfCurrentPlayers").getValue(), "Citizen");
        playerUniqueRef.setValue(new Player(name, "" + playerID, "Citizen"));
        numberOfCurrentPlayersRef.setValue(playerID + 1);
    }

    public void refreshValues(GameSession game) {
        gameRef.setValue(game);
    }

    public int getNumberOfPlayers(DataSnapshot ds) {
        return (int)ds.child("players").getChildrenCount();
    }

    public void setNumberOfPlayers(int num) {
        gameRef.child("numberOfCurrentPlayers").setValue(num);
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public DatabaseReference getGameRef() {
        return gameRef;
    }

    public DatabaseReference getPlayersRef() {
        return this.playersRef;
    }

    public void updateDB(GameSession gameSessionRef) {
        this.gameRef.setValue(gameSessionRef);
    }
}
