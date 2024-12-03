package pond.cards;

import utils.IOmanager;
import main.Player;

public class Duck extends PondCard {
    private Player owner;

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
    }

    @Override
    public String printCard() {
        return owner.getName() + "'s duck";
    }
}