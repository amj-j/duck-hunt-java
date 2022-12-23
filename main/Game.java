package main;

import utils.IOmanager;
import utils.Constants;

public class Game {
    Board board;

    public Game() {
        int playersNum = IOmanager.printAndReadInt("How many players will there be?");
        while (playersNum < Constants.MIN_PLAYERS || playersNum > Constants.MAX_PLAYERS) {
            playersNum = IOmanager.printAndReadInt("Enter valid number of players");
        }
        board = new Board(playersNum);

    }
    
} 
