package main;

import java.util.ArrayList;
import utils.KeyboardInput;
import utils.Constants;
import action.ActionDeck;
import action.ActionCard;
import pond.PondDeck;
import pond.Pond;
import pond.AimTiles;
import pond.pond_cards.Duck;
import pond.pond_cards.Water;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Deck actionDeck = new Deck();
    private Deck pondDeck = new Deck();
    private Pond pond = new Pond();
    private AimTiles aimTiles = new AimTiles();;

    public Game() {
        int playersNum = KeyboardInput.readInt("How many players will there be?");
        while (!checkPlayersNum(playersNum)) {
            playersNum = KeyboardInput.readInt("Enter valid number of players");
        }
        
        initPlayers(playersNum);
        initPondDeck();
        //initPond();
        //initActionDeck();


        /*pondDeck.fillPond(pond);

        actionDeck = new ActionDeck();
        actionDeck.shuffle();
        dealCards();*/
    }

    private boolean checkPlayersNum(int playersNum) {
        if (playersNum >= Constants.MIN_PLAYERS && playersNum <= Constants.MAX_PLAYERS) {
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

    private void initPondDeck() {
        Duck duck;
        for (Player player : players) {
            duck = new Duck(player);
            pondDeck.addTypeOfCards(duck, players.size());
        }
        Water water = new Water();
        pondDeck.addTypeOfCards(water, Constants.WATER_NUM);

        pondDeck.shuffle();
    }

    private void initPond() {

    }

    private void initActionDeck() {

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
