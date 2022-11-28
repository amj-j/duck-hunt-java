package main;

import java.util.ArrayList;
import utils.KeyboardInput;
import action.ActionDeck;
import action.ActionCard;
import pond.PondDeck;
import pond.Pond;

public class Game {
    private ArrayList<Player> players;
    private ActionDeck actionDeck;
    private PondDeck pondDeck;
    private Pond pond;

    public Game() {
        int playersNum = KeyboardInput.readInt("How many players will there be?");
        while (!checkPlayersNum(playersNum)) {
            playersNum = KeyboardInput.readInt("Enter valid number of players");
        }
        
        initPlayers(playersNum);

        pondDeck = new PondDeck(players);
        pondDeck.shuffle();
        pondDeck.fillPond(pond);

        actionDeck = new ActionDeck();
        actionDeck.shuffle();
        dealCards();
    }

    private boolean checkPlayersNum(int playersNum) {
        if (playersNum >= 2 && playersNum <= 6) {
            return true;
        }
        else {
            return false;
        }
    }

    private void initPlayers(int playersNum) {
        String name;
        for (int i = 0; i < playersNum; i++) {
            name = KeyboardInput.readString("Enter the name of Player " + i+1);
            players.add(new Player(name));
        }

    }

    private void dealCards() {
        ActionCard card;
        for (Player player : players) {
            for (int i = 0; i < 3; i++) {
                card = actionDeck.takeFromTop();
                player.addCard(card, i);
            }
        }
    }
} 
