package action_cards;

import utils.Constants;
import utils.IOmanager;
import main.Board;
import pond.pond_cards.PondCard;

public class DuckDance extends ActionCard {

    public DuckDance(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.println("You chose Scatter");
        PondCard card;
        for (int i = 0; i < Constants.POND_SIZE; i++) {
            card = board.pond.takeFromTop();
            board.pondDeck.addToBottom(card);
        }
        board.pondDeck.shuffle();
        for (int i = 0; i < Constants.POND_SIZE; i++) {
            card = (PondCard) board.pondDeck.takeFromTop();
            board.pond.addToTop(card);
        }
    }

    @Override
    public String printCard() {
        return "Duck Dance";
    }
}
