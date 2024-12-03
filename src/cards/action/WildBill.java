package cards.action;

import main.Board;
import pond.cards.Duck;
import pond.cards.PondCard;
import utils.IOmanager;

public class WildBill extends ActionCard {

    public WildBill(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.println("You chose Wild Bill");
        int index = getPondIndex("What tile do you shoot at?");       
        PondCard card = board.pond.getCard(index);
        card.shot();
        if (card instanceof Duck) {
            board.pond.addToBottom(board.pondDeck.takeFromTop());
            board.pond.removeCard(index);
        }
    }

    @Override
    public String printCard() {
        return "Wild Bill";
    }
}
