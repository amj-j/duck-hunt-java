package action_cards;

import main.Board;
import utils.IOmanager;
import pond.pond_cards.PondCard;
import pond.pond_cards.Duck;

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
