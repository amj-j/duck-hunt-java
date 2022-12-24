package action_cards;

import utils.IOmanager;
import main.Board;

public class Aim extends ActionCard {

    public Aim(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.println("You chose Aim");
        int index = getPondIndex("What tile do you aim at?");   
        board.aimTiles.aimAt(index);
    }
}
