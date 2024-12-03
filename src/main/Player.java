package main;

import utils.Constants;
import utils.IOmanager;
import cards.action.ActionCard;
import cards.action.Shoot;
import exceptions.NothingAimedException;

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
                IOmanager.println("You can't play Shoot because nothing is aimed!");
            }
        }
    }

    public void playCard(int cardNum)throws NothingAimedException {
        ActionCard card = hand[cardNum];
        card.play();
        board.actionDeck.addToBottom(card);
        card = (ActionCard)board.actionDeck.takeFromTop();
        hand[cardNum] = card;
    }

    public void swapIfNecessary() {
        ActionCard card;
        while (mustSwitchCard()) {
            card = hand[Constants.CARDS_ON_HAND - 1];
            board.actionDeck.addToBottom(card);
            card = (ActionCard)board.actionDeck.takeFromTop();
            hand[Constants.CARDS_ON_HAND - 1] = card;
        }
    }

    public boolean mustSwitchCard() {
        for (ActionCard card : hand) {
            if (!(card instanceof Shoot)) {
                return false;
            }
        }
        if (board.aimTiles.anyAimed()) {
            return false;
        }
        return true;
    }

    public void printHand() {
        for (int i = 0; i < Constants.CARDS_ON_HAND; i++) {
            IOmanager.println((i+1) + ". " + hand[i].printCard());
        }
    }
}
