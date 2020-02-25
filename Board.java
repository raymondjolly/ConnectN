package com.rvj;


import java.util.Arrays;

public class Board {
    private Integer[][] board;

    public Board(int rows, int cols) {
        this.board = new Integer[rows][cols];
        for (Integer[] row : board) {
            Arrays.fill(row, 0);
        }
    }

    public Integer getGamePiece(int row, int col) {
        return this.board[row][col];
    }

    public int getFreeSpaceLeftInColumn(int col) {
        int count = 0;
        for (int i = 0; i < getBoardHeight(); i++) {
            if (board[i][col].equals(0)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isColumnPlayable(int col) {
        if (getFreeSpaceLeftInColumn(col) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setGamePiece(int col, int value) {
        int count = 0;
        if (getFreeSpaceLeftInColumn(col)>=0) {
            for (int i = 0; i < getBoardHeight(); i++) {
                if (board[i][col].equals(0)) {
                    count += 1;
                }
                board[getBoardHeight() - count][col] = value;
            }
        }
    }

    public int getBoardWidth() {
        return this.board.length;
    }

    public int getBoardHeight() {
        return this.board[0].length;
    }

    public Integer[][] getBoardValues() {
        return this.board;
    }

    public void printBoard(){
        for(int xLabel=0; xLabel< getBoardWidth(); xLabel++){
            System.out.print(String.format("%4s", xLabel +1));
        }
        System.out.println();
        //print board
        for(int row =0; row<getBoardWidth(); row++){
            System.out.print("| ");
            for(int col=0; col<getBoardWidth(); col++){
                switch (getGamePiece(row, col)){
                    case 1:
                        System.out.print("P1|");
                        break;
                    case 2:
                        System.out.print("P2|");
                        break;
                    case 3:
                        System.out.print("P3|");
                        break;
                    default:
                        System.out.print(". |");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
