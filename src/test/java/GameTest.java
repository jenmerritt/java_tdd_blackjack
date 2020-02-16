import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

        private Game game;
        private Player player;
        private Deck deck;
        private Dealer dealer;
        private Card cardOne;
        private Card cardTwo;
        private Scorer scorer;

        @Before
        public void before() {
            player = new Player();
            cardOne = new Card(SuitType.HEARTS, RankType.TWO);
            cardTwo = new Card(SuitType.HEARTS, RankType.TEN);
            dealer = new Dealer();
            game = new Game(dealer, player, scorer);
        }

        @Test
        public void checkDealerHasTwoCardsAfterDealing(){
            game.dealBlackjackCards();
            assertEquals(2, dealer.getNumberOfCardsInHand());
        }

        @Test
        public void checkPlayerHasTwoCardsAfterDealing(){
            game.dealBlackjackCards();
            assertEquals(2, player.getNumberOfCardsInHand());
        }



}
