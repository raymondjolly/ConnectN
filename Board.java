package com.rvj;


public class Board {
    private Token[][] board;


    public Board(int rows, int cols) {
        this.board = new Token[rows][cols];
    }

    public boolean setGameToken(int col, Token t){
        for (int row=board.length-1;row>=0;row--){
            if(col>=0 && col<board[row].length){
                if(board[row][col] == null){
                    board[row][col] = t;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPlayable(){
        for (Token[] tokens : board) {
            for (Token token : tokens) {
                if (token == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard(){
        System.out.println();
        for(int j=0; j<board[0].length; j++){
            System.out.printf("____", j+1);
        }
        System.out.println();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == null){
                    System.out.print("|   ");
                }
                else{
                    System.out.print("|  " +board[i][j].getToken() + " ");
                }
            }
            System.out.println("|");
        }
        for(int j=0; j<board[0].length; j++){
            System.out.printf("____", j+1);
        }
        System.out.println();
        for(int j=0; j<board[0].length; j++){
            System.out.printf("  %d ", j+1);
        }
        //System.out.println("  1   2   3   4   5   6   7");
    }

}
