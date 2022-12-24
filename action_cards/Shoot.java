package action_cards;

import main.Board;
import utils.IOmanager;
import pond.pond_cards.PondCard;
import pond.pond_cards.Duck;

public class Shoot extends ActionCard {

    public Shoot(Board board) {
        this.board = board;
    }

    @Override
    public void play() {
        IOmanager.println("You chose Shoot");
        int index = getPondIndex("What tile do you shoot at?");   
        if (board.aimTiles.isAimed(index)) {
            board.aimTiles.removeAim(index);
            PondCard card = board.pond.getCard(index);
            card.shot();
            if (card instanceof Duck) {
                board.pond.addToBottom(board.pondDeck.takeFromTop());
                board.pond.removeCard(index);
            }
        }
        else {
            IOmanager.println("This tile is not aimed!");
            play();
        }
    }

    @Override
    public String printCard() {
        return "Shoot";
    }
}
