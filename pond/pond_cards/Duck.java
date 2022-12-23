package pond.pond_cards;

import utils.IOmanager;
import main.Player;

public class Duck extends PondCard {
    Player owner;

    public Duck(Player owner) {
        this.owner = owner;
    }

    @Override
    public void shot() {
        owner.takeLife();
        IOmanager.print("You shot " + owner.getName() + "'s duck");
    }
}
