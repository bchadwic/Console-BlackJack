package cards;

/**
 * Card is the parent class of both SetCard, and StandardCard in the cardgame package
 * Card represents a generic card that can hold a description called cardText
 *
 * @author Ben
 * @version 1.0
 */

public class Card {

    // fields
    private String cardText;

    /**
     * The card constructor takes in a cardText which is a description of the card
     * Then it assigns it to the cardText field
     */
    public Card(String cardText){
        this.cardText = cardText;

    }

    /**
     *
     * @return the string that is hold in the field cardText
     */
    public String getCardText(){
        return cardText;
    }

    /**
     *
     * @return the string in format that is presentable using the cardText field
     */
    public String toString(){
        return cardText;
    }
}