package cards.action;

import utils.IOmanager;
import main.Board;
import pond.cards.PondCard;

public class DuckMarch extends ActionCard {

    public DuckMarch(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.println("You chose Duck March");
        PondCard card = board.pond.takeFromTop();
        board.pondDeck.addToBottom(card);
        card = (PondCard) board.pondDeck.takeFromTop();
        board.pond.addToBottom(card);
    }

    @Override
    public String printCard() {
        return "Duck March";
    }
}
