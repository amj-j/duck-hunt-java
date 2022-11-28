package pond;

import java.util.ArrayList;
import main.Player;
import pond.pond_cards.PondCard;
import pond.pond_cards.Duck;
import pond.pond_cards.Water;

public class PondDeck {
    ArrayList<PondCard> deck;
    
    public PondDeck(ArrayList<Player> players) {
        deck = new ArrayList<PondCard>();
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                deck.add(new Duck(player));
            }
            deck.add(new Water());
        }
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
