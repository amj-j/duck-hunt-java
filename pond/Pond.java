package pond;

import main.Deck;
import pond.pond_cards.PondCard;

public class Pond extends Deck{

    public PondCard getCard(int index) {
        return (PondCard) deck.get(index);
    }

    @Override
    public PondCard takeFromTop() {
        PondCard rtrn = getCard(0);
        deck.remove(0);
        return rtrn;
    }

    public void addToTop(PondCard card) {
        deck.add(0, card);
    }

    public void removeCard(int index) {
        deck.remove(index);
    }
}
