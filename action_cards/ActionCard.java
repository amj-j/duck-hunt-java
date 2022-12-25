package action_cards;

import utils.IOmanager;
import utils.Constants;
import main.Card;
import main.Board;
import exceptions.NothingAimedException;

abstract public class ActionCard extends Card {
    protected Board board;

    public void play() throws NothingAimedException {}

    protected int getPondIndex(String text) {
        return IOmanager.readIntInRange(
            1, Constants.POND_SIZE+1, 
            text, 
            "Enter valid number"
        ) - 1;
    }
}
