package com.example.mafiarolegame.gameElements;

public class Player /*implements Shootable */{
    private String name;
    private String id;
    private boolean alive;
    private String role;
    //gal enumą geriau parašyt bet kam čia terliotis? Jankus sad
    //negeriau, nereikia cia svaigt apie visokius enumus b***, man ir taip niekas neveikia ******!!!

    public Player() {

    }

    public Player(String name, String id, String role) {
        this.name = name;
        this.id = id;
        alive = true;
        this.role = role;
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
}
