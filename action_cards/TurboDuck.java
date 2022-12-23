package action_cards;

import utils.IOmanager;
import main.Board;
import pond.pond_cards.PondCard;
import pond.pond_cards.Duck;

public class TurboDuck extends ActionCard {

    public TurboDuck(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.print("You chose Turbo Duck");
        int index = getPondIndex("What tile is the duck you want to move on?");
        PondCard card = board.pond.getCard(index);
        if (card instanceof Duck) {
            board.pond.removeCard(index);
            board.pond.addToTop(card);
        }
        else {
            IOmanager.print("You can't move water!");
            play();
        }
    }
}
