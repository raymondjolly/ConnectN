package com.rvj;

/**
 * Player interface defines the methods that will be used for the Bot
 * and Human classes
 */
public interface Player{

    String getName();
    String getPlayerInput();
    Token getToken();

}
