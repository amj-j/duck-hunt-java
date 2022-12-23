package action_cards;

import utils.IOmanager;
import main.Board;

public class Scatter extends ActionCard {

    public Scatter(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.print("You chose Scatter");
        board.pond.shuffle();
    }
}