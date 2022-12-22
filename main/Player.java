package main;

import action.ActionCard;
import action.ActionDeck;
import utils.Constants;

public class Player {
    private String name;
    private int lives = Constants.LIVES_NUM;
    private ActionCard[] cards = new ActionCard[Constants.CARDS_ON_HAND];

    public Player(String name) {
        this.name = name;
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

    /*public void addCard(ActionCard card, int index) {
        cards[index] = card;
    }

    public boolean playCard(int cardNum, ActionDeck deck) {
        if (cardNum >= Constants.CARDS_ON_HAND || cardNum < 0) {
            return false;
        }
        else {
            ActionCard card = cards[cardNum];
            card.play();
            deck.addToBottom(card);
            card = deck.takeFromTop();
            cards[cardNum] = card;
            return true;
        }
    }*/

}
