
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {
    private Deck deck;

    public DeckTest() {
    }

    @Before
    public void before() {
        this.deck = new Deck();
    }

    @Test
    public void cardsStartEmpty() {

        assertEquals(0L, (long)this.deck.getNumberOfCards());
    }

    @Test
    public void canPopulateDeck() {
        this.deck.populate();
        assertEquals(52L, (long)this.deck.getNumberOfCards());
    }

    @Test
    public void canDealCard() {
        this.deck.populate();
        this.deck.shuffleCards();
        this.deck.dealCard();
        assertEquals(51L, (long)this.deck.getNumberOfCards());
    }
}
