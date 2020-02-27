package com.rvj;

import java.util.Random;

public class ComputerPlayer implements Player {

    private Random number;
    private Token token;

    public ComputerPlayer(Token token) {
        this.number = new Random();
        this.token = token;
    }


    @Override
    public String getInput() {
        //the range should eventually be the width of the board
        int rand = number.nextInt(7)+1;
        return Integer.toString(rand);
    }

    @Override
    public Token getToken() {
        return token;
    }

}
