package deck;

import cards.Card;
import org.junit.Test;

/**
 * This test is covers the methods used by Deck to verify functionality
 * @author Ben
 * @version 1.0
 */

import static org.junit.Assert.assertEquals;

public class DeckTest {

    /**
     * testAddCard verifies that the Card and Deck can be constructed
     */
    @Test
    public void testAddCard(){
        Card testCard = new Card("Joker");
        Deck testDeck = new Deck();

        assertEquals("size of stock deck is incorrect", 0, testDeck.cardCount());
        testDeck.addCard(testCard);
        assertEquals("size of deck with one card is incorrect", 1, testDeck.cardCount());

    }
}
