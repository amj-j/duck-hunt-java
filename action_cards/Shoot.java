package action_cards;

import main.Board;
import utils.Constants;
import utils.IOmanager;

public class Shoot extends ActionCard {

    public Shoot(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.print("You chose Shoot");
        int index = IOmanager.printAndReadInt("What tile do you shoot at?");
        while (index < 0 || index >= Constants.POND_SIZE) {
            index = IOmanager.printAndReadInt("Enter valid number");
        }
        if (board.aimTiles.isAimed(index)) {
            board.pond.shootAt(index);
        }
        else {
            IOmanager.print("This tile is not aimed!");
            play();
        }
    }
}
