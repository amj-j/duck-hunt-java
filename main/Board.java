package main;

import java.util.ArrayList;

import action_cards.*;
import utils.IOmanager;
import utils.Constants;

import pond.*;
import pond.pond_cards.*;

public class Board {
    public ArrayList<Player> players = new ArrayList<Player>();
    public Deck actionDeck = new Deck();
    public Deck pondDeck = new Deck();
    public Pond pond = new Pond();
    public AimTiles aimTiles = new AimTiles();

    public Board(int playersNum) {
        initPlayers(playersNum);
        initPondDeck();
        initPond();
        initActionDeck();
        dealCards();
    }

    private void initPlayers(int playersNum) {
        String name;
        for (int i = 0; i < playersNum; i++) {
            name = IOmanager.printAndReadString("Enter the name of player" + (i+1));
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
        actionDeck.addTypeOfCards(new Aim(this), Constants.AIM);
        actionDeck.addTypeOfCards(new DuckDance(this), Constants.DUCK_DANCE);
        actionDeck.addTypeOfCards(new DuckMarch(this), Constants.DUCK_MARCH);
        actionDeck.addTypeOfCards(new Scatter(this), Constants.SCATTER);
        actionDeck.addTypeOfCards(new Shoot(this), Constants.SHOOT);
        actionDeck.addTypeOfCards(new TurboDuck(this), Constants.TURBO_DUCK);
        actionDeck.addTypeOfCards(new WildBill(this), Constants.WILD_BILL);
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