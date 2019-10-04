package com.example.mafiarolegame.gameElements;

public class Player implements Shootable {
    public String name;
    boolean alive = true;
    //gal enumą geriau parašyt bet kam čia terliotis? Jankus sad

    public Player(String name) {
        this.name = name;
    }

    public void setIsAlive(boolean b) {
        alive = b;
    }

    public void getShot() {
        setIsAlive(false);
    }

    public void getHealed() {
        setIsAlive(true);
    }
}
