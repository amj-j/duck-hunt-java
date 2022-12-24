package main;

import utils.IOmanager;
import utils.Constants;

public class Game {
    Board board;

    public Game() {
        int playersNum = IOmanager.readIntInRange(
            Constants.MIN_PLAYERS, 
            Constants.MAX_PLAYERS+1,
            "How many players will there be?", 
            "Enter valid number of players"
        );
        board = new Board(playersNum);

        while (true) {
            round();
            if (board.players.size() == 0) {
                break;
            }
        }
    }
    
    private void round() {
        for (int i = 0; i < board.players.size(); i++) {
            Player player = board.players.get(i);
            printRound(player);

            int cardNum = IOmanager.readIntInRange(
                1, 
                Constants.CARDS_ON_HAND+1, 
                "Which card do you wish to play?", 
                "Enter valid number"
            ) - 1;
            player.playCard(cardNum);

            
        }
    }

    private void printRound(Player player) {
        board.printBoard();
        IOmanager.println(player.getName() + "'s turn:");
        player.printHand();
        IOmanager.println("\n");
    }
} 

