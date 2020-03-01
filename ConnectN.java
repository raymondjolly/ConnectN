package com.rvj;

import java.util.ArrayList;


/**
 * ConnectN Class
 */
public class ConnectN {

    private Board board;
    private int opponents;
    public static int tokensToWin;

    /**
     * ConnectN Constructor
     * @param tokensToWin Tokens To Win
     * @param opponents Opponents
     */
    public ConnectN(int tokensToWin, int opponents){
        this.opponents = opponents;
        ConnectN.tokensToWin = tokensToWin;
        board = new Board();
    }

    /**
     * playGame instantiates the player related objects, tracks turns, and
     * win conditions
     */
    public void playGame(){

        Human player1 = new Human("The Human",new Token('R'));
        BotPlayer player2 = new BotPlayer("W.O.P.R", new Token('Y'));


        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        if(opponents==2){
            BotPlayer player3 = new BotPlayer("Hal 9000", new Token('B'));
            players.add(player3);
        }

        int turn = 0;
        int colSelected=0;


        board.printBoard();

        while(board.isPlayable()){
            Player currentPlayer = players.get(turn%players.size());

            boolean success = false;
            while (!success) {
                try{
                    colSelected = Integer.parseInt(currentPlayer.getPlayerInput());
                    success = true;
                }
                catch (NumberFormatException e){
                    System.out.println("Move not valid - try again");
                    colSelected=0;
                }
            }

            // Subtract 1 from selected column
            colSelected=colSelected-1;

            // Place token on board
            boolean valid = board.placeToken(colSelected,currentPlayer.getToken());

            // Check whether valid move
            while(!valid){
                System.out.println("Move not valid - try again");
                colSelected = Integer.parseInt(currentPlayer.getPlayerInput());

                // Subtract 1 from selected column for user input
                colSelected=colSelected-1;

                valid = board.placeToken(colSelected, currentPlayer.getToken());
            }

            // Check for a win condition
            if(board.checkForWin(currentPlayer.getToken())){
                board.printBoard();
                System.out.println(currentPlayer.getName() + " has won!");
                break;
            }

            board.printBoard();
            System.out.println();
            turn++;
        }
        System.out.println("Game Has Ended");
    }
}