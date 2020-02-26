package com.rvj;

public class Player {
    private String name;
    //used to track the number of players in the game.
    private static int counter;

    public Player(String name) {
        this.name = name;
        this.counter+=1;
    }

    public static Player createPlayer(String name){
        return new Player(name);
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }
}
