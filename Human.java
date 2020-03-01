package com.rvj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Human implements Player{

    private String name;
    private BufferedReader in;
    private Token token;

    // Constructor method
    public Human(String name,Token t){
        this.name = name;
        this.token = t;
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getPlayerInput(){
        try{
            return in.readLine();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Token getToken(){
        return token;
    }

}
