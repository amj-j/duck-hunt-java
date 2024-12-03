package cards.action;

import utils.IOmanager;
import main.Board;
import pond.cards.Duck;
import pond.cards.PondCard;

public class TurboDuck extends ActionCard {

    public TurboDuck(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.println("You chose Turbo Duck");
        int index = getPondIndex("What tile is the duck you want to move on?");
        PondCard card = board.pond.getCard(index);
        if (card instanceof Duck) {
            board.pond.removeCard(index);
            board.pond.addToTop(card);
        }
        else {
            IOmanager.println("You can't move water!");
            play();
        }
    }

    @Override
    public String printCard() {
        return "Turbo Duck";
    }
}
