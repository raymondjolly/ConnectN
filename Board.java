package com.rvj;


import java.util.Arrays;

public class Board {
    private Integer[][] board;

    public Board(int rows, int cols) {
        this.board = new Integer[rows][cols];
        for(Integer[] row: board){
            Arrays.fill(row, 0);
        }
    }

    public Integer getPiece(int row, int col){
        return this.board[row][col];
    }

    public void setPiece(int row, int col, int value){
        this.board[row][col] = value;
    }

    public int getBoardWidth(){
        return this.board.length;
    }

    public int getBoardHeight(){
        return this.board[0].length;
    }

    public Integer[][] getBoardValues(){
        return this.board;
    }

    public void printBoardValues(){
        //print column headers
        System.out.print("     ");
        for(int xLabel = 0; xLabel<getBoardWidth(); xLabel++){
            System.out.println(String.format("%2s", xLabel));
        }
        System.out.println();
        //print board
        for(int row=0; row<getBoardHeight(); row++){
            System.out.print(String.format("%2s", row+1));
            for(int col=0; col<getBoardWidth(); col++){
                switch (getPiece(row, col)){
                    case 1:
                        System.out.print("P1");
                        break;
                    case 2:
                        System.out.print("P2");
                        break;
                    case 3:
                        System.out.print("P3");
                        break;
                    default:
                        System.out.println(".");
                        break;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
