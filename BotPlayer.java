package com.rvj;

import java.util.Random;

/**
 * BotPlayer Class
 */
public class BotPlayer implements Player{

    private String name;
    private Random rand;
    private Token token;

    /**
     * BotPlayer constructor
     * @param name player name
     * @param t token
     */
    public BotPlayer(String name,Token t){
        this.name = name;
        this.token = t;
        this.rand = new Random();
    }

    /**
     * getPlayerInput
     * @return
     */
    public String getPlayerInput(){
        Integer r = rand.nextInt(7)+1;
        return (r.toString());
    }

    /**
     * getName method
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getToken method
     * @return token
     */
    public Token getToken(){
        return token;
    }

}