package action_cards;

import utils.IOmanager;
import main.Board;
import pond.pond_cards.PondCard;

public class DuckMarch extends ActionCard {

    public DuckMarch(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.print("You chose Duck March");
        PondCard card = board.pond.takeFromTop();
        board.pondDeck.addToBottom(card);
        card = (PondCard) board.pondDeck.takeFromTop();
        board.pond.addToBottom(card);
    }
}
