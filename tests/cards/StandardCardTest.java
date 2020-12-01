package cards;
import deck.StandardDeck;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * This is a test for the StandardCard class
 * @author Ben
 * @version 1.0
 */

public class StandardCardTest {

    @Test
    public void testConstructor(){

        StandardCard ace = new StandardCard("Ace", "Spade");
        assertEquals("Card rank is incorrect", "Ace", ace.getRank());
        assertEquals("Card suit is incorrect", "Spade", ace.getSuit());

    }

    @Test
    public void testToString(){

        StandardCard ace = new StandardCard("Ace", "Spade");
        assertEquals("Card rank is incorrect", "Ace of Spade", ace.toString());
    }

    @Test
    public void testGetRankValue(){
        StandardCard a = new StandardCard("2", "Spade");
        StandardCard b = new StandardCard("5", "Spade");
        StandardCard c = new StandardCard("10", "Spade");
        StandardCard d = new StandardCard("Queen", "Spade");
        StandardCard e = new StandardCard("Ace", "Spade");

        assertEquals("Two is perceived at " + a.getRankValue(), convertRank(a.getRank()), a.getRankValue());
        assertEquals("Five is perceived at " + b.getRankValue(), convertRank(b.getRank()), b.getRankValue());
        assertEquals("Ten is perceived at " + c.getRankValue(), convertRank(c.getRank()), c.getRankValue());
        assertEquals("Queen is perceived at " + d.getRankValue(), convertRank(d.getRank()), d.getRankValue());
        assertEquals("Ace is perceived at " + e.getRankValue(), convertRank(e.getRank()), e.getRankValue());

    }

    public int convertRank(String c){
        if( c=="Ace"){
            return 11;
        } else if ((c == "Jack") || (c == "Queen") || (c == "King")){
            return 10;
        } else {
            return Integer.parseInt(c);
        }
    }
}
