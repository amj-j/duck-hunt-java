package pond;

import main.Deck;
import pond.pond_cards.PondCard;

public class Pond extends Deck{

    private PondCard getCard(int index) {
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

    public PondCard popCard(int index) {
        PondCard card = getCard(index);
        deck.remove(card);
        return card;
    }

    public void shootAt(int index) {
        getCard(index).shot();
    }

    

}
