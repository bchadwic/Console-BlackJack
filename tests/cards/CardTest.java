package cards;

// import used classes
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a test for the class Card
 * @author Ben
 * @version 1.0
 */

public class CardTest {


    @Test
    public void testConstructor(){

        Card joker = new Card("Joker");
        assertEquals("Card is correct", "Joker", joker.getCardText());
    }

    @Test
    public void testToString(){
        Card joker = new Card("Joker");
        System.out.println(joker);
    }

}
