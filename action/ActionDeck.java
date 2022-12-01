package action;

import java.util.ArrayList;
import java.util.Random;
import action.action_cards.Aim;
import action.action_cards.Shoot;
import action.action_cards.WildBill;
import action.action_cards.DuckMarch;
import action.action_cards.TurboDuck;
import action.action_cards.Scatter;
import action.action_cards.DuckDance;

public class ActionDeck {
    private final int AIM_NUM = 10;
    private final int SHOOT_NUM = 12;
    private final int WILD_BILL_NUM = 2;
    private final int DUCK_MARCH_NUM = 6;
    private final int TURBO_DUCK_NUM = 1;
    private final int SCATTER_NUM = 2;
    private final int DUCK_DANCE_NUM = 1;

    private ArrayList<ActionCard> deck;

    public ActionDeck() {
        deck = new ArrayList<ActionCard>();

        Aim aim = new Aim();
        Shoot shoot = new Shoot();
        WildBill wildBill = new WildBill();
        DuckMarch duckMarch = new DuckMarch();
        TurboDuck turboDuck = new TurboDuck();
        Scatter scatter = new Scatter();
        DuckDance duckDance = new DuckDance();


        for (int i = 0; i < AIM_NUM; i++) {
            deck.add(aim);
        }

        for (int i = 0; i < SHOOT_NUM; i++) {
            deck.add(shoot);
        }

        for (int i = 0; i < WILD_BILL_NUM; i++) {
            deck.add(wildBill);
        }

        for (int i = 0; i < DUCK_MARCH_NUM; i++) {
            deck.add(duckMarch);
        }

        for (int i = 0; i < TURBO_DUCK_NUM; i++) {
            deck.add(turboDuck);
        }

        for (int i = 0; i < SCATTER_NUM; i++) {
            deck.add(scatter);
        }

        for (int i = 0; i < DUCK_DANCE_NUM; i++) {
            deck.add(duckDance);
        }
    }

    public ActionCard takeFromTop() {
        ActionCard rtrn = deck.get(0);
        deck.remove(0);
        return rtrn;
    }

    public void addToBottom(ActionCard newLast) {
        deck.add(newLast);
    }

    public void shuffle() {
        Random rand = new Random();
        ActionCard tmp;
        for (int i = 0; i < deck.size(); i++) {
            tmp = deck.get(i);
            deck.remove(i);
            deck.add(rand.nextInt(deck.size()), tmp);
        }
    }
}
