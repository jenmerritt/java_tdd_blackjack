import java.util.ArrayList;

public class Dealer {
    private Deck deck = new Deck();
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Dealer() {
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public int getNumberOfCardsInHand(){
        return this.hand.size();
    }

    public Deck setupDeckOfShuffledCards() {
        this.deck.populate();
        this.deck.shuffleCards();
        return this.deck;
    }

    public ArrayList<Card> dealTwoCards() {
        setupDeckOfShuffledCards();
        Card firstCard = this.deck.dealCard();
        Card secondCard = this.deck.dealCard();
        ArrayList<Card> dealtCards = new ArrayList<Card>();
        dealtCards.add(firstCard);
        dealtCards.add(secondCard);
        return dealtCards;
    }

    public ArrayList<Card> dealTwoCardsToDealerHandAndProvidePlayersHand() {
        setupDeckOfShuffledCards();
        Card firstCard = this.deck.dealCard();
        Card secondCard = this.deck.dealCard();
        Card thirdCard = this.deck.dealCard();
        Card fourthCard = this.deck.dealCard();
        ArrayList<Card> cardsDealtForPlayer = new ArrayList<Card>();
        cardsDealtForPlayer.add(firstCard);
        this.hand.add(secondCard);
        cardsDealtForPlayer.add(thirdCard);
        this.hand.add(fourthCard);
        return cardsDealtForPlayer;
    }

    public Card dealAdditionalCard(Deck deck){
        return deck.dealCard();
    }

    public Deck getDeck() {
        return this.deck;
    }
}
