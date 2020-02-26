package com.rvj;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Board board = new Board(4, 4);
        board.printBoard();
        board.setGamePiece(0, 1);
        System.out.println(board.getFreeSpaceLeftInColumn(0));
        board.printBoard();
        System.out.println();
        ConnectN connectN = new ConnectN(4,5);
        connectN.gameSetup(1);
        int count = connectN.getPlayerCount();
        System.out.println(count);
        //connectN.getPlayer(0);

    }
}
