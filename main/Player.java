package main;

import action_cards.ActionCard;
import utils.Constants;
import utils.IOmanager;
import exceptions.NothingAimedException;
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

    public void turn() {
        int cardNum;
        while (true) {
            cardNum = IOmanager.readIntInRange(
                1, 
                Constants.CARDS_ON_HAND+1, 
                "Which card do you wish to play?", 
                "Enter valid number"
            ) - 1;
            try {
                playCard(cardNum);
                break;
            }
            catch (NothingAimedException e) {
                IOmanager.print("You can't play Shoot because nothing is aimed!");
            }
        }
    }

    public void playCard(int cardNum)throws NothingAimedException {
        ActionCard card = hand[cardNum];
        card.play();
        do {
            card = hand[cardNum];
            board.actionDeck.addToBottom(card);
            card = (ActionCard)board.actionDeck.takeFromTop();
            hand[cardNum] = card;
        } while (mustSwitchCard());
    }

    private boolean mustSwitchCard() {
        for (ActionCard card : hand) {
            if (!(card instanceof Shoot)) {
                return false;
            }
        }
        return true;
    }

    public void printHand() {
        for (int i = 0; i < Constants.CARDS_ON_HAND; i++) {
            IOmanager.println((i+1) + ". " + hand[i].printCard());
        }
    }
}
