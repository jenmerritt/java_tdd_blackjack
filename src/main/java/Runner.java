import java.util.ArrayList;

public class Runner {

    public Runner() {
    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        Player player = new Player();
        Scorer scorer = new Scorer();
        Game game = new Game(dealer, player, scorer);
        game.playRound();
    }
}