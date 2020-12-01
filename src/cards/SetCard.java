package cards;

/**
 * SetCard is a Card that represents a card that is used for a game with nonstandard cards
 */
public class SetCard extends Card {

    private String shape;
    private int number;
    private String shading;
    private String color;

    /**
     *
     * @param shape the shape on the card
     * @param number the number on the card
     * @param shading the shading on the card
     * @param color the color of the card
     * SetCard constructor takes in all the parameters and sets the fields, as well as giving the super class a cardText
     */
    public SetCard(String shape, int number, String shading, String color) {
        super("shape: " + shape + ", number: " + number + ", shading: " + shading + ", color: " + color);
        this.shape = shape;
        this.number = number;
        this.shading = shading;
        this.color = color;
    }

    /**
     *
     * @return the shape on the card
     */
    public String getShape() {
        return shape;
    }

    /**
     *
     * @return the number on the card
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @return the shading on the card
     */
    public String getShading() {
        return shading;
    }

    /**
     *
     * @return the color of the card
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @return the card description in a usable String format
     */
    public String toString(){
        return super.toString();
    }
}

