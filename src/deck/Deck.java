package deck;

// Imported classes
import cards.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class represents a deck that can be added to, dealt, discarded, and shuffled
 * @author Ben
 * @version 1.0
 */

public class Deck {
    private ArrayList<Card> dealerPile = new ArrayList<Card>();
    private ArrayList<Card> discardPile  = new ArrayList<Card>();

    // default constructor
    public Deck(){

    }

    /**
     * addCard takes in a card for a parameter and inserts it into the dealerPile
     */
    public void addCard(Card card){
        dealerPile.add(card);
    }

    /**
     * shuffle puts all the cards from the discardPile back into the dealerPile, then shuffles the dealerPile
     */
    public void shuffle(){
        // cycling through discardPile to add them to the dealerPile
        if(discardPile.size() != 0) {
            for (int i = 0; i < discardPile.size(); i++) {
                Card discardCard = discardPile.get(i);
                dealerPile.add(discardCard);
            }
        }
        // clears the discardPile
        discardPile.clear();
        // create a random generator
        Random gen = new Random();

        // shuffle card location by the amount of the deck size, then reiterate the amount of the deck size
        for(int i=0; i<=dealerPile.size(); i++){
            Collections.swap(dealerPile, gen.nextInt(dealerPile.size()), gen.nextInt(dealerPile.size()));
        }


    }

    /*
     dealTopCard will take the top card of dealerPile and discard it while returning it as well
     */
    public Card dealTopCard(){
        if(dealerPile.size() == 0)
            return null;
        Card holder = dealerPile.get(dealerPile.size()-1);
        discardPile.add(holder);
        dealerPile.remove(dealerPile.size()-1);
        return discardPile.get(discardPile.size()-1);
    }

    /*
    cardCount takes the size of the dealerPile and returns it.
     */
    public int cardCount(){
        return dealerPile.size();
    }

    @Override
    /*
    toString for this class utilizes the StringBuilder to compile all the deck cards
    and print them in an appealing way
     */
    public String toString() {
        // create StringBuilder
        StringBuilder deck = new StringBuilder(dealerPile.size()+" cards in the deck");
        deck.append("\n*****************");
        // loop through the size of the dealerPile and append each to the string
        for(int i=0; i<dealerPile.size(); i++){
            deck.append("\n"+dealerPile.get(i));
        }
        deck.append("\n");
        deck.append("\n"+discardPile.size()+" cards in discard");
        deck.append("\n*****************");
        // loop through the size of the discardPile and append each to the string
        for(int i=0; i<discardPile.size(); i++){
            deck.append("\n"+discardPile.get(i));
        }
        // take the string from StringBuilder and convert it to a String so that it can be returned
        String output = deck.toString();
        return output;
    }
}
