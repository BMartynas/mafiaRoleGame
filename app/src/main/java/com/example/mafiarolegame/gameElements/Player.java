package com.example.mafiarolegame.gameElements;

public class Player {
    private String name;
    boolean status = true;  //true - alive, false - dead
                            //gal enumą geriau parašyt bet kam čia terliotis? Jankus sad

    public Player(String name) {
        this.name = name;
    }

    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }

}
