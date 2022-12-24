package main;

import action_cards.ActionCard;
import utils.Constants;
import utils.IOmanager;
import action_cards.Shoot;

public class Player {
    private String name;
    private int lives = Constants.START_LIVES;
    private ActionCard[] hand = new ActionCard[Constants.CARDS_ON_HAND];
    protected Board board;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public int getLives() {
        return lives;
    }

    public void takeLife() {
        lives--;
    }

    public String getName() {
        return name;
    }

    public void addCard(ActionCard card, int index) {
        hand[index] = card;
    }

    public boolean playCard(int cardNum) {
        ActionCard card = hand[cardNum];
        card.play();
        board.actionDeck.addToBottom(card);
        card = (ActionCard)board.actionDeck.takeFromTop();
        hand[cardNum] = card;
        return true;

    }

    public void printHand() {
        for (int i = 0; i < Constants.CARDS_ON_HAND; i++) {
            IOmanager.println((i+1) + ". " + hand[i].printCard());
        }
    }
}
