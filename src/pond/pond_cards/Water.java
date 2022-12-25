package pond.pond_cards;

import utils.IOmanager;

public class Water extends PondCard {
    @Override
    public void shot() {
        IOmanager.println("You hit water!");
    }

    @Override
    public String printCard() {
        return "Water";
    }
}
