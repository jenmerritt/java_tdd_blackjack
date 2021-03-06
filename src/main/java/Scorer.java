import java.util.ArrayList;

public class Scorer {
    public Scorer() {
    }

    // Blackjack game

    public static int calculateScore(ArrayList<Card> hand){
        int totalScore = 0;
        for(Card card : hand){
            totalScore += card.getCardScore();
        }
        return totalScore;
    }

    public static int doesHandContainAce(ArrayList<Card> hand){
        for(Card card : hand){
            if(card.getRank() == RankType.ACE){
                return 1;
            }
            else{
                return 2;
            }
        }
        return 3;
    }



    // Higher / Lower game - score is incremental from 0-13 in order on RankType enum list:
    public static String compareTwoPlayersScores(Player playerOne, Player playerTwo) {
        int playerOneScore = playerOne.getCardRank().ordinal();
        int playerTwoScore = playerTwo.getCardRank().ordinal();
        if (playerOneScore > playerTwoScore) {
            return "Player One Wins";
        } else {
            return playerTwoScore > playerOneScore ? "Player Two Wins" : "Draw";
        }
    }

 // simple high/low comparison game of 2 cards for player and dealer:

    public static String compareDealerAndPlayerHands(Player player, Dealer dealer){
        Card playerCardOne = player.getHand().get(0);
        Card playerCardTwo = player.getHand().get(1);
        int playerTotalScore = playerCardOne.getCardScore() + playerCardTwo.getCardScore();
        Card dealerCardOne = dealer.getHand().get(0);
        Card dealerCardTwo = dealer.getHand().get(1);
        int dealerTotalScore = dealerCardOne.getCardScore() + dealerCardTwo.getCardScore();
        if(dealerTotalScore > playerTotalScore){
            return "Dealer wins with " + dealerTotalScore;
        } else {
            return playerTotalScore > dealerTotalScore ? "Player wins with " + playerTotalScore : "Draw";
        }
    }

    public boolean isBlackjack(ArrayList<Card> hand) {
        if (calculateScore(hand) == 21) {
            return true;
        } else return false;
    }
}
