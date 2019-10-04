package com.example.mafiarolegame.gameElements;

public class Doctor extends Citizen {

    public Doctor(String name) {
        super(name);
    }

    public void heal(Player player) {
        player.getHealed();
    }
}
