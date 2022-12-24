package action_cards;

import main.Board;
import utils.IOmanager;
import pond.pond_cards.PondCard;

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
    }
}
