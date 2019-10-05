package com.example.mafiarolegame.gameElements;

public class Player implements Shootable {
    private String name;
    private String id;
    private boolean alive;
    //gal enumą geriau parašyt bet kam čia terliotis? Jankus sad

    public Player(String name, String id) {
        this.name = name;
        this.id = id;
        alive = true;

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
