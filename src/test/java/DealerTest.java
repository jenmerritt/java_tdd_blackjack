
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DealerTest {
    private Dealer dealer;

    public DealerTest() {
    }

    @Before
    public void before() {
        this.dealer = new Dealer();
    }

    @Test
    public void canDealTwoCards() {
        ArrayList<Card> dealtCards = this.dealer.dealTwoCards();
        assertEquals(2, dealtCards.size());
    }

    @Test
    public void dealTwoCardsToDealerHand(){
        this.dealer.dealTwoCardsToDealerHandAndProvidePlayersHand();
        assertEquals(2, this.dealer.getNumberOfCardsInHand());
    }

    @Test
    public void ProvideTwoCardsForPlayersHand(){
        ArrayList<Card> playersCards = this.dealer.dealTwoCardsToDealerHandAndProvidePlayersHand();
        assertEquals(2, playersCards.size());
    }

}
