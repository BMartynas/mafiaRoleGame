package com.example.mafiarolegame.gameElements;

public class Doctor extends Citizen {

    public Doctor(String name, String id) {
        super(name, id);
    }

    public void heal(Player player) {
        player.getHealed();
    }
}
