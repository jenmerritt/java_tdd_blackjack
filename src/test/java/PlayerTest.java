
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;
    private Card card;
    private Card card2;

    public PlayerTest() {
    }

    @Before
    public void before() {
        this.player = new Player();
        this.card = new Card(SuitType.HEARTS, RankType.ACE);
        this.card2 = new Card(SuitType.DIAMONDS, RankType.TWO);
    }

    @Test
    public void canGetRankOfCard() {
        this.player.addCard(this.card);
        assertEquals(RankType.ACE, this.player.getCardRank());
    }

    @Test
    public void canAddTwoCardsFromDealtHand(){
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(card);
        testHand.add(card2);
        assertEquals(2, testHand.size());
    }
}
