package com.rvj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer implements Player {

    private BufferedReader reader;
    private Token token;

    public HumanPlayer(Token token) {
        this.token = token;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getInput(){
        try{
            return reader.readLine();
        }catch (IOException ioe){
            System.err.println("You did it wrong.");
        }
        return null;
    }

    @Override
    public Token getToken() {
        return token;
    }
}
