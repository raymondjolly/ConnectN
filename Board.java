package com.rvj;

/**
 * Board Class
 */
public class Board{

    private Token[][] board;

    /**
     * Board constructor
     */
    public Board(){
        board = new Token[6][7];
    }

    /**
     * placeToken places player token in the selected column
     * @param col column
     * @param t token
     * @return boolean
     */
    public boolean placeToken(int col, Token t){
        int i;

        for (i=board.length-1;i>=0;i--){
            if(col>=0 && col<board[i].length){
                if(board[i][col] == null){
                    board[i][col] = t;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * isPlayable checks if a given column is free to set a token
     * @return boolean
     */
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

    /**
     * checkWin method
     * borrowed and modified concept from
     * https://stackoverflow.com/questions/39062111/java-how-to-check-diagonal-connect-four-win-in-2d-array
     * @param token token
     * @return boolean win
     */
    public boolean checkForWin(Token token) {
        //checks for consecutive matched tokens
        int consecutiveCount = ConnectN.tokensToWin -1;
        //2D array to check in relative position
        int[][] directions = {{1,0}, {1,-1}, {1,1}, {0,1}};
        for (int[] d : directions) {
            int dx = d[0];
            int dy = d[1];
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    int lastX = x + consecutiveCount*dx;
                    int lastY = y + consecutiveCount*dy;
                    //restrict check of valid boundary conditions
                    if (0 <= lastX && lastX < board.length && 0 <= lastY && lastY < board[0].length) {
                        Token player = board[x][y];

                        if (player != null && player == board[x+dx][y+dy]
                                && player == board[x+2*dx][y+2*dy]
                                && player == board[lastX][lastY]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * printBoard method prints the current Token state of the two dimensional
     * array board
     */
    public void printBoard(){
        for (Token[] tokens : board) {
            for (Token token : tokens) {
                if (token == null) {
                    System.out.print("|   ");
                } else {
                    System.out.print("| " + token.getToken() + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println();
    }
}