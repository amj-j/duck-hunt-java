package action_cards;

import utils.IOmanager;
import utils.Constants;
import main.Card;
import main.Board;

abstract public class ActionCard extends Card {
    protected Board board;

    public void play() {}

    protected int getPondIndex(String text) {
        int index = IOmanager.printAndReadInt(text) - 1;
        while (index < 0 || index >= Constants.POND_SIZE) {
            index = IOmanager.printAndReadInt("Enter valid number") - 1;
        }
        return index;
    }
}
