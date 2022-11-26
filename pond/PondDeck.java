package pond;

import java.util.ArrayList;
import pond.pond_cards.PondCard;

public class PondDeck {
    ArrayList<PondCard> deck;
    
    public void add(PondCard card) {
        deck.add(card);
    }

    public PondCard takeFromTop() {
        PondCard rtrn = deck.get(0);
        deck.remove(0);
        return rtrn;
    }

    public void addToBottom(PondCard newLast) {
        deck.add(newLast);
    }

    public void shuffle() {

    }

    public void fillPond(Pond pond) {
        PondCard card;
        for (int i = 0; i < 6; i++) {
            card = takeFromTop();
            pond.add(card);
        }
    }
}
