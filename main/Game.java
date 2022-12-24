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
            if (board.players.size() == 1) {
                break;
            }
        }
        board.lostPlayers.add(board.players.get(0).getName());
        printLostPlayers();
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
            if (board.removedPlayerIndex >= 0) {
                if (board.removedPlayerIndex <= i) {
                    --i;
                }
                board.removedPlayerIndex = -1;
            }
        }
    }

    private void printRound(Player player) {
        board.printBoard();
        IOmanager.println("");
        IOmanager.println(player.getName() + "'s turn:");
        player.printHand();
        IOmanager.println("");
    }

    private void printLostPlayers() {
        int place = 1;
        for (int i = board.lostPlayers.size() -1; i >= 0; i--) {
            IOmanager.println(place + ". " + board.lostPlayers.get(i));
            place++;
        }
    }
} 

