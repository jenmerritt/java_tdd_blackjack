import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {
    private Card card;

    public CardTest() {
    }

    @Before
    public void before() {
        this.card = new Card(SuitType.HEARTS, RankType.KING);
    }

    @Test
    public void canGetSuit() {
       assertEquals(SuitType.HEARTS, this.card.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(RankType.KING, this.card.getRank());
    }

    @Test
    public void canGetBlackjackScore(){
        assertEquals(10, this.card.getCardScore());
    }
}
