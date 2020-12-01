package cards;

/**
 * StandardCard is a Card that has a rank and a suit (ex. Ace of Spades)
 * @author Ben
 * @version 1.0
 */

public class StandardCard extends Card {
    private String rank;
    private String suit;

    /**
     *
     * @param rank is the rank of the StandardCard (A-K)
     * @param suit is the suit of the StandardCard (hearts, clubs, diamonds, spade)
     * StandardCard constructor takes in the parameters as well as creating a cardText for the super class
     */
    public StandardCard(String rank, String suit){
        super(rank + " of " + suit);
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @return the rank of this StandardCard
     */
    public String getRank(){
        return rank;
    }

    /**
     * @return the suit of this StandardCard
     */
    public String getSuit(){
        return suit;
    }

    /**
     * @return the StandardCard in format of the rank "of" the suit
     */
    public String toString(){
        return super.toString();
    }

    /**
     * getRankValue converts the String card rank and turns it into the respective int
     * @return the number that represents the value in Black Jack
     */
    public int getRankValue(){
        if(rank == "Ace"){
            return 11;
        } else if((rank == "Jack") || (rank == "Queen") || (rank == "King")){
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }
}
