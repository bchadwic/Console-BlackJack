package cards;

// import used classes
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This is a test for the SetCard class
 * @author Ben
 * @version 1.0
 */

public class SetCardTest {

    @Test
    public void testConstructor(){

        SetCard test = new SetCard("Oval", 5, "Light", "Green");

        assertEquals("Card shape is incorrect", "Oval", test.getShape());
        assertEquals("Card number is incorrect", 5, test.getNumber());
        assertEquals("Card shading is incorrect", "Light", test.getShading());
        assertEquals("Card color is incorrect", "Green", test.getColor());
    }
    @Test
    public void testToString(){
        SetCard test = new SetCard("Oval", 5, "Light", "Green");
        assertEquals("Card rank is incorrect", "shape: Oval, number: 5, shading: Light, color: Green", test.toString());
    }
}
