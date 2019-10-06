package com.example.mafiarolegame.gameElements;

public class Mafia extends Player {
    public Mafia(String name, String id) {
        super(name, id);
    }

    public void shoot(Shootable player) {
        player.getShot();
    }
}
