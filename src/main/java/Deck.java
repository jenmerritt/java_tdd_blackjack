import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList();

    public Deck() {
    }

    public int getNumberOfCards() {

        return this.cards.size();
    }

    public void populate() {
        this.cards.clear();
        for (SuitType suit : SuitType.values()){
            for (RankType rank : RankType.values()){
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffleCards() {

        Collections.shuffle(this.cards);
    }

    public ArrayList<Card> getCards() {

        return this.cards;
    }

    public Card dealCard() {

        return (Card)this.cards.remove(0);
    }
}
