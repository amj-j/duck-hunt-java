package action;
import java.util.ArrayList;

public class ActionDeck {
    private ArrayList<ActionCard> deck;

    public ActionCard takeFromTop() {
        ActionCard rtrn = deck.get(0);
        deck.remove(0);
        return rtrn;
    }

    public void addToBottom(ActionCard newLast) {
        deck.add(newLast);
    }
}
