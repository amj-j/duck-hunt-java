package main;

import java.util.ArrayList;
import utils.KeyboardInput;
import action.ActionDeck;
import pond.PondDeck;
import pond.Pond;
import pond.pond_cards.Duck;
import pond.pond_cards.Water;

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
        initPondCards();
        initActionCards();
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

    private void initPondCards() {
        for (Player player : this.players) {
            for (int i = 0; i < 5; i++) {
                pondDeck.add(new Duck(player));
            }
            pondDeck.add(new Water());
        }
        pondDeck.shuffle();
        pondDeck.fillPond(pond);
    }

    private void initActionCards() {
        
    }
} 
