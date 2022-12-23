package main;

import utils.IOmanager;

public class Game {
    Board board;

    public Game() {
        board = new Board(IOmanager.getPlayersNum());
    }
    
} 
