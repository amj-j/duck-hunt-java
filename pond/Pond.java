package pond;

import java.util.ArrayList;
import pond.pond_cards.PondCard;
import main.Deck;

public class Pond extends Deck{

    public Pond() {
        
    } 

    
    public void add(PondCard card) {
        pondTiles.add(card);
    }
}
