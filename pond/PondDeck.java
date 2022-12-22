package pond;

import java.util.ArrayList;
import java.util.Random;
import main.Player;
import main.Deck;
import pond.pond_cards.PondCard;
import pond.pond_cards.Duck;
import pond.pond_cards.Water;

public class PondDeck extends Deck {
    
    public PondDeck(ArrayList<Player> players) {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                deck.add(new Duck(player));
            }
            deck.add(new Water());
        }
    }

    

    public void fillPond(Pond pond) {
        PondCard card;
        for (int i = 0; i < 6; i++) {
            card = takeFromTop();
            pond.add(card);
        }
    }
}
