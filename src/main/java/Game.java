import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Dealer dealer;
    private Player player;
    private Scorer scorer;

    public Game(Dealer dealer, Player player, Scorer scorer) {
        this.dealer = dealer;
        this.player = player;
        this.scorer = scorer;
    }

    public void dealBlackjackCards() {
        dealer.setupDeckOfShuffledCards();
        ArrayList<Card> playersHand = dealer.dealTwoCardsToDealerHandAndProvidePlayersHand();
        player.addTwoCardsFromDealtHand(playersHand);
        returnInitialHandsString();
    }

    public void returnInitialHandsString() {
        System.out.println("Player has " + player.getHand().get(0).getRank() + " and " + player.getHand().get(1).getRank() + ". Dealer top card is: " + dealer.getHand().get(1).getRank());
    }

    public void printAddedCard() {
        Card addedCard = player.getHand().get(player.getNumberOfCardsInHand() - 1);
        System.out.println("Additional card: " + addedCard.getRank());
        System.out.println("Your new total is: " + scorer.calculateScore(player.getHand()));
    }
// Holding as it works before refactor to Ace stuff:

//    public void playRound() {
//        dealBlackjackCards();
//        Scanner stickOrTwist = new Scanner(System.in); // get input
//        Boolean proceed = true;
//        while(proceed) {
//                System.out.println("Stick (1) or Twist (2)?");
//                int userResponse = stickOrTwist.nextInt();  // Read user input
//                if(userResponse == 1){
//                    proceed = false;
//                    System.out.println("You chose to Stick");
//                    System.out.println("Your total is: " + scorer.calculateScore(player.getHand()));
//                    compareDealerHand();
//                }
//                if(userResponse == 2 && scorer.calculateScore(player.getHand()) < 21){
//                    Card newCard = dealer.dealAdditionalCard(dealer.getDeck());
//                    player.getHand().add(newCard);
//                    printAddedCard();
//                }
//                if(scorer.calculateScore(player.getHand()) > 21){
//                    proceed = false;
//                    System.out.println("Bust!");
//                }
//        }
//
//        }

    public void playRound() {
        dealBlackjackCards();
        Scanner stickOrTwist = new Scanner(System.in); // get input
        Boolean proceed = true;
        while (proceed) {
            System.out.println("Stick (1) or Twist (2)?");
            int userResponse = stickOrTwist.nextInt();  // Read user input
            if (userResponse == 1) {
                proceed = false;
                System.out.println("You chose to Stick");
                System.out.println("Your total is: " + scorer.calculateScore(player.getHand()));
                compareDealerHand();
            }
            if (userResponse == 2 && scorer.calculateScore(player.getHand()) < 21) {
                Card newCard = dealer.dealAdditionalCard(dealer.getDeck());
                player.getHand().add(newCard);
                printAddedCard();
            }
            if (scorer.calculateScore(player.getHand()) > 21) {
                proceed = false;
                System.out.println("Bust!");
            }
        }

    }

    public void compareDealerHand() {
        Boolean proceed = true;
        while (proceed) {
            if (scorer.calculateScore(dealer.getHand()) >= 16 && scorer.calculateScore(dealer.getHand()) <= 21) {
                proceed = false;
                System.out.println("Dealer total is: " + scorer.calculateScore(dealer.getHand()));
                declareWinner();
            }
            if (scorer.calculateScore(dealer.getHand()) < 16) {
                Card newCard = dealer.dealAdditionalCard(dealer.getDeck());
                dealer.getHand().add(newCard);
            }
            if (scorer.calculateScore(dealer.getHand()) > 21) {
                proceed = false;
                System.out.println("Dealer is bust! Player Wins!");
            }
        }
    }

    public void declareWinner() {
        if (scorer.calculateScore(dealer.getHand()) > scorer.calculateScore(player.getHand())) {
            System.out.println("Dealer wins!");
        }
        if (scorer.calculateScore(dealer.getHand()) < scorer.calculateScore(player.getHand())) {
            System.out.println("Player wins!");
        }
        if (scorer.calculateScore(dealer.getHand()) == scorer.calculateScore(player.getHand())) {
            System.out.println("Draw!");
        }
    }

    public void playAgain() {
        boolean again = true;
        while (again) {
            Scanner playAgain = new Scanner(System.in); // get input
            System.out.println("Play Again? Yes (1) or No (2)");
            int userResponse = playAgain.nextInt();  // Read user input
            if (userResponse == 1) {
                player.getHand().clear();
                dealer.getHand().clear();
                playRound();
            }
            if (userResponse == 2) {
                again = false;
            }
        }

    }

}




    // Calculate winner as having highest hand, no other Blackjack rules:

//    public String compareHandsAndReturnHighScoreWinner(Player player, Dealer dealer){
//        int PlayerScore = scorer.calculateScore(player.getHand());
//        int DealerScore = scorer.calculateScore(dealer.getHand());
//        if(PlayerScore > DealerScore){
//            return "Player Wins";
//        } else {
//            return DealerScore > PlayerScore ? "Dealer wins" : "Draw";
//        }
//    }




