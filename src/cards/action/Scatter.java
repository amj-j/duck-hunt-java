package cards.action;

import utils.IOmanager;
import main.Board;

public class Scatter extends ActionCard {

    public Scatter(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.println("You chose Scatter");
        board.pond.shuffle();
    }

    @Override
    public String printCard() {
        return "Scatter";
    }
}
