package action_cards;

import main.Board;
import utils.Constants;
import utils.IOmanager;

public class WildBill extends ActionCard {

    public WildBill(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.print("You chose Wild Bill");
        int index = IOmanager.printAndReadInt("What tile do you shoot at?");
        while (index < 0 || index >= Constants.POND_SIZE) {
            index = IOmanager.printAndReadInt("Enter valid number");
        }
        board.pond.shootAt(index);
    }
}
