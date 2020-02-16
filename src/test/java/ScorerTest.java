
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScorerTest {
    private Player playerOne;
    private Player playerTwo;
    private Card cardOne;
    private Card cardTwo;

    public ScorerTest() {
    }

    @Before
    public void before() {
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.cardOne = new Card(SuitType.HEARTS, RankType.TWO);
        this.cardTwo = new Card(SuitType.HEARTS, RankType.TEN);
    }

    @Test
    public void canCompareCardsPlayerOneWins() {
        this.playerOne.addCard(this.cardTwo);
        this.playerTwo.addCard(this.cardOne);
        assertEquals("Player One Wins", Scorer.compareTwoPlayersScores(this.playerOne, this.playerTwo));
    }

    @Test
    public void canCompareCardsPlayerTwoWins() {
        this.playerOne.addCard(this.cardOne);
        this.playerTwo.addCard(this.cardTwo);
        assertEquals("Player Two Wins", Scorer.compareTwoPlayersScores(this.playerOne, this.playerTwo));
    }

    @Test
    public void canCompareCardsDraw() {
        this.playerOne.addCard(this.cardOne);
        this.playerTwo.addCard(this.cardOne);
        assertEquals("Draw", Scorer.compareTwoPlayersScores(this.playerOne, this.playerTwo));
    }
}
