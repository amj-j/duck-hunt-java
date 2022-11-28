package main;
import action.ActionCard;
import action.ActionDeck;

public class Player {
    private String name;
    private int lives;
    private ActionCard[] cards;

    public Player(String name) {
        this.name = name;
        lives = 5;
        cards = new ActionCard[3];
    }

    public int getLives() {
        return lives;
    }

    public void takeLife() {
        lives--;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCard(ActionCard card, int index) {
        cards[index] = card;
    }

    public boolean playCard(int cardNum, ActionDeck deck) {
        if (cardNum > 2 || cardNum < 0) {
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
    }

}
