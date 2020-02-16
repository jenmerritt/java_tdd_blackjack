import java.util.ArrayList;

public class Runner {

    public Runner() {
    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        System.out.println("Dealer created");
        Player player = new Player();
        System.out.println("player created");
        Scorer scorer = new Scorer();
        System.out.println("scorer created");
        Game game = new Game(dealer, player, scorer);
        System.out.println("game created");
//        String result = game.compareHandsAndReturnHighScoreWinner( player, dealer);
//        game.dealBlackjackCards();
        game.playRound();
    }
}