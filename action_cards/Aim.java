package action_cards;

import utils.IOmanager;
import utils.Constants;
import main.Board;

public class Aim extends ActionCard {

    public Aim(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        int index = IOmanager.printAndReadInt("What tile do you aim at?");
        while (index < 0 || index >= Constants.POND_SIZE) {
            index = IOmanager.printAndReadInt("Enter valid number");
        }
        board.aimTiles.aimAt(index);
    }
}
