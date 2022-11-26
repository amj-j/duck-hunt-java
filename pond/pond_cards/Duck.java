package pond.pond_cards;

import main.Player;

public class Duck extends PondCard {
    Player owner;

    public Duck(Player owner) {
        this.owner = owner;
    }
}
