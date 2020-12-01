package deck;

/**
 * StandardDeck is a Deck that represents a standard set of 52 cards
 * (A,2,3,4,5,6,7,8,9,10,J,Q,K) * four suits (clubs, diamonds, hearts, spades)
 * @author Ben
 * @version 1.0
 */

//import StandardCard because the StandardDeck acts as a holder for the StandardCards
import cards.StandardCard;

public class StandardDeck extends Deck {

    /**
     * StandardDeck constructor makes a deck of 52 StandardCards
     */
    public StandardDeck(){
        // Create a String array to  hold all the suits being used in StandardDeck
        String[] suit = {"clubs", "diamonds", "hearts", "spades"};
        // Create a for loop to iterate through the indices of the suit array
        for(int i = 0; i < 4; i++){
            // Add an ace to the StandardDeck
            this.addCard(new StandardCard("Ace", suit[i]));
            /* Create a for loop to iterate through 2 - 10 cards,
            then assign a suit while being added to the StandardDeck
             */
            for(int rank=2; rank<11; rank++){
                this.addCard(new StandardCard(String.valueOf(rank), suit[i]));
            }
            // Add Jack, Queen, and King to the StandardDeck
            this.addCard(new StandardCard("Jack", suit[i]));
            this.addCard(new StandardCard("Queen", suit[i]));
            this.addCard(new StandardCard("King", suit[i]));
        }
    }

    /**
     * this method overrides the Deck method dealTopCard
     * @return the top card using the Deck dealTopCard method, then cast it as a StandardCard before returning it
     */
    @Override
    public StandardCard dealTopCard(){
        return (StandardCard) super.dealTopCard();
    }
}
