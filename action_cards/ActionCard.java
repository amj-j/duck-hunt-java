package action_cards;

import utils.IOmanager;
import utils.Constants;
import main.Card;
import main.Board;

public class ActionCard extends Card {
    protected Board board;

    public void play() {}

    protected int getPondIndex(String text) {
        int index = IOmanager.printAndReadInt(text);
        while (index < 0 || index >= Constants.POND_SIZE) {
            index = IOmanager.printAndReadInt("Enter valid number");
        }
        return index;
    }
}
