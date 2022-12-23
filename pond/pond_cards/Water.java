package pond.pond_cards;

import utils.IOmanager;

public class Water extends PondCard {
    @Override
    public void shot() {
        IOmanager.print("You hit water!");
    }
}
