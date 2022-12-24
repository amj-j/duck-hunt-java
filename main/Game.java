package main;

import java.util.ArrayList;

import utils.IOmanager;
import utils.Constants;

public class Game {
    Board board;
    ArrayList<String> lostPlayers = new ArrayList<String>();

    public Game() {
        int playersNum = IOmanager.printAndReadInt("How many players will there be?");
        while (playersNum < Constants.MIN_PLAYERS || playersNum > Constants.MAX_PLAYERS) {
            playersNum = IOmanager.printAndReadInt("Enter valid number of players");
        }
        board = new Board(playersNum);

        while (true) {
            round();
            if (board.players.size() == 0) {
                break;
            }
        }
    }
    
    private void round() {
        for (Player player : board.players) {
            board.printBoard();
            IOmanager.println(player.getName() + "'s turn:");
            player.printHand();
            IOmanager.println("\n");
            int cardNum = IOmanager.printAndReadInt("Which card do you wish to play?") - 1;
            while (cardNum < 0 || cardNum >= Constants.CARDS_ON_HAND) {
                cardNum = IOmanager.printAndReadInt("Enter valid number") - 1;
            }
            player.playCard(cardNum);

            for (Player lostPlayer : board.players) {
                if (lostPlayer.getLives() <= 0) {
                    lostPlayers.add(lostPlayer.getName());
                    board.players.remove(lostPlayer);
                }
            }
        }
    }
} 

