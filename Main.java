package com.rvj;


class Main {
    public static void main(String[] args) {

        //The variables below can be modified to check for different test conditions
        int connectN = 5;
        int opponents = 3;

        System.out.println("Welcome to ConnectN");

        ConnectN g = new ConnectN(connectN, opponents);
        g.playGame();

    }
}
