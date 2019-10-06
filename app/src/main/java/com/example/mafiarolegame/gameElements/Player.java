package com.example.mafiarolegame.gameElements;

public class Player /*implements Shootable */{
    private String name;
    private String id;
    private boolean alive;
    //gal enumą geriau parašyt bet kam čia terliotis? Jankus sad

    public Player() {

    }

    public Player(String name, String id) {
        this.name = name;
        this.id = id;
        alive = true;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsAlive() {
        return alive;
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
