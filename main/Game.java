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
        mainCycle();
    }

    private void mainCycle() {
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
            player.turn();   
            int indexOfLostPlayer = checkIfLost();
            if (indexOfLostPlayer != -1) {
                removePlayer(indexOfLostPlayer);
                if (indexOfLostPlayer <= i) {
                    --i;
                }
            }
        }
    }

    private int checkIfLost() {
        for (int i = 0; i < board.players.size(); i++) {
            if (board.players.get(i).getLives() == 0) {
                return i;
            }
        }
        return -1;
    }

    private void removePlayer(int index) {
        String playerName = board.players.get(index).getName();
        IOmanager.println(playerName + " lost");
        board.lostPlayers.add(playerName);
        board.players.remove(index);
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

