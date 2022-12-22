package main;

import java.util.ArrayList;

import action_cards.*;
import utils.KeyboardInput;
import utils.Constants;

import pond.*;
import pond.pond_cards.*;

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
        initPond();
        initActionDeck();
        dealCards();
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
        for (Player player : players) {
            pondDeck.addTypeOfCards(new Duck(player), Constants.START_LIVES);
        }
        pondDeck.addTypeOfCards(new Water(), Constants.WATER);

        pondDeck.shuffle();
    }

    private void initPond() {
        Card card;
        for (int i = 0; i < Constants.POND_SIZE; i++) {
            card = pondDeck.takeFromTop();
            pond.addToBottom(card); 
        }
    }

    private void initActionDeck() {
        actionDeck.addTypeOfCards(new Aim(), Constants.AIM);
        actionDeck.addTypeOfCards(new DuckDance(), Constants.DUCK_DANCE);
        actionDeck.addTypeOfCards(new DuckMarch(), Constants.DUCK_MARCH);
        actionDeck.addTypeOfCards(new Scatter(), Constants.SCATTER);
        actionDeck.addTypeOfCards(new Shoot(), Constants.SHOOT);
        actionDeck.addTypeOfCards(new TurboDuck(), Constants.TURBO_DUCK);
        actionDeck.addTypeOfCards(new WildBill(), Constants.WILD_BILL);
    }

    private void dealCards() {
        ActionCard card;
        for (Player player : players) {
            for (int i = 0; i < Constants.CARDS_ON_HAND; i++) {
                card = (ActionCard)actionDeck.takeFromTop();
                player.addCard(card, i);
            }
        }
    }
} 
