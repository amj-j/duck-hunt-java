package action_cards;

import main.Board;
import utils.IOmanager;
import pond.pond_cards.PondCard;

public class Shoot extends ActionCard {

    public Shoot(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.print("You chose Shoot");
        int index = getPondIndex("What tile do you shoot at?");   
        if (board.aimTiles.isAimed(index)) {
            PondCard card = board.pond.getCard(index);
            card.shot();
        }
        else {
            IOmanager.print("This tile is not aimed!");
            play();
        }
    }
}
