package cards.action;

import main.Board;
import pond.cards.Duck;
import pond.cards.PondCard;
import utils.IOmanager;
import exceptions.NothingAimedException;

public class Shoot extends ActionCard {

    public Shoot(Board board) {
        this.board = board;
    }

    @Override
    public void play() throws NothingAimedException {
        IOmanager.println("You chose Shoot");

        if (!board.aimTiles.anyAimed()) {
            throw new NothingAimedException();
        }

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
