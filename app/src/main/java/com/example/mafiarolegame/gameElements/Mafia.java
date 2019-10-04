package com.example.mafiarolegame.gameElements;

public class Mafia extends Player {
    public Mafia(String name) {
        super(name);
    }

    public void shoot(Shootable player) {
        player.getShot();
    }
}
