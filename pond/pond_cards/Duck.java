package pond.pond_cards;

import utils.IOmanager;
import main.Player;
import main.Board;

public class Duck extends PondCard {
    private Player owner;
    private Board board;

    public Duck(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public void shot() {
        owner.takeLife();
        IOmanager.println("You shot " + owner.getName() + "'s duck");
        if (owner.getLives() == 0) {
            board.lostPlayers.add(owner.getName());
            board.removedPlayerIndex = board.players.indexOf(owner);
            board.players.remove(owner);
        }
    }

    @Override
    public String printCard() {
        return owner.getName() + "'s duck";
    }
}