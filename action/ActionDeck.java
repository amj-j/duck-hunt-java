package action;

import java.util.ArrayList;
import action.action_cards.Aim;
import action.action_cards.Shoot;
import action.action_cards.WildBill;
import action.action_cards.DuckMarch;
import action.action_cards.TurboDuck;
import action.action_cards.Scatter;
import action.action_cards.DuckDance;

public class ActionDeck {
    private int AIM_NUM = 10;
    private int SHOOT_NUM = 12;
    private int WILD_BILL_NUM = 2;
    private int DUCK_MARCH_NUM = 6;
    private int TURBO_DUCK_NUM = 1;
    private int SCATTER_NUM = 2;
    private int DUCK_DANCE_NUM = 1;

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
}
