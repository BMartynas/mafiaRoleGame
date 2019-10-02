package com.example.mafiarolegame.gameElements;

public class Citizen extends Player implements Shootable {
    public Citizen() {
        super("Citizen");
    }

    public void toGetShot() {
        super.setStatus(false);
    }

}
