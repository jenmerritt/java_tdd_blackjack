import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList();

    public Player() {
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public void addCard(Card card) {

        this.hand.add(card);
    }

    public RankType getCardRank() {
        Card card = (Card)this.hand.get(0);
        return card.getRank();
    }

    public int getNumberOfCardsInHand(){
        return this.hand.size();
    }

    public void addTwoCardsFromDealtHand(ArrayList<Card> hand){
        Card firstCard = hand.get(0);
        Card secondCard = hand.get(1);
        this.hand.add(firstCard);
        this.hand.add(secondCard);
    }

}