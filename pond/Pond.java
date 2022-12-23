package pond;

import main.Deck;
import pond.pond_cards.PondCard;

public class Pond extends Deck{

    private PondCard getCard(int index) {
        return (PondCard) deck.get(index);
    }

    public void shootAt(int index) {
        getCard(index).shot();
    }
}
