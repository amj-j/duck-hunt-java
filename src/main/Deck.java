package main;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    protected ArrayList<Card> deck = new ArrayList<Card>();

    public Card takeFromTop() {
        Card rtrn = deck.get(0);
        deck.remove(0);
        return rtrn;
    }

    public void addToBottom(Card newLast) {
        deck.add(newLast);
    }

    public void shuffle() {
        Random rand = new Random();
        Card tmp;
        for (int i = 0; i < deck.size(); i++) {
            tmp = deck.get(i);
            deck.remove(i);
            deck.add(rand.nextInt(deck.size()), tmp);
        }
    }

    public void addTypeOfCards(Card card, int until) {
        for (int i = 0; i < until; i++) {
            deck.add(card);
        }
    }
}
