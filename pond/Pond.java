package pond;

import java.util.ArrayList;
import pond.pond_cards.PondCard;

public class Pond {
    private ArrayList<PondCard> pondTiles;

    public Pond() {
        pondTiles = new ArrayList<PondCard>();
    } 

    
    public void add(PondCard card) {
        pondTiles.add(card);
    }
}
