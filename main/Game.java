package main;

import java.util.ArrayList;
import action.ActionDeck;
import pond.PondDeck;
import pond.Pond;

public class Game {
    private ArrayList<Player> players;
    private ActionDeck actionDeck;
    private PondDeck pondDeck;
    private Pond pond;

    public Game() {
        
    }

    private boolean initPlayers(int playersNum) {
        if (playersNum > 6 || playersNum < 2) {
            return false;
        }
        else {
            for (int i = 0; i < playersNum; i++) {
                //TODO
            }
        }return true;
    }
}
