/**
 * This class represents a the rules and mechanics of the Black Jack game
 * Included in this class is the deck, the card amount of both players and the welcome message
 * @author Ben Chadwick
 * @version 1.0
 * created on 11/17/2020
 */


package game;

import cards.StandardCard;
import deck.StandardDeck;

import java.util.stream.Stream;

public class BlackJack {
    private int playerTotal;
    private int dealerTotal;
    private StandardDeck deck;

    public BlackJack(){
        deck = new StandardDeck();
        deck.shuffle();
        playerTotal = 0;
        dealerTotal = 0;
        welcome();
    }

    /**
     * getPlayerTotal retrieves the player's total card count
     * @return playerTotal is the card count of the player
     */
    public int getPlayerTotal(){
        return playerTotal;
    }

    /**
     * getDealerTotal retrieves the dealers total card count
     * @return dealerTotal is the card count of the dealer
     */
    public int getDealerTotal(){
        return dealerTotal;
    }

    /**
     * setPlayerTotal sets the card count for the player
     * @param t is the total amount to set the player total to
     */
    public void setPlayerTotal(int t){
        playerTotal = t;
    }

    /**
     * setDealerTotal sets the card count for the dealer
     * @param t is the total amount to set the player total to
     */
    public void setDealerTotal(int t){
        dealerTotal = t;
    }

    /**
     * dealTwoCards deals out two cards to the player / dealer hand
     * @return the Stream contains the cards being returned
     */
    public Stream<StandardCard> dealTwoCards(){ return Stream.of(dealOneCard(), dealOneCard()); }

    /**
     * dealOneCard deals out a single card to the player / dealer hand
     * @return the StandardCard at the top of the deck
     */
    public StandardCard dealOneCard(){
        if(deck.cardCount() == 0){
            System.out.println("No more cards, shuffling deck");
            deck.shuffle();
        }
        return deck.dealTopCard();
    }

    /**
     * welcome prints the starting greeting message
     */
    public void welcome(){
        System.out.println(
                "****************************************\n" +
                "Welcome to my Blackjack console program!\n" +
                "****************************************\n" +
                "\nGenerating a new standard deck of cards\n" +
                "Shuffling deck..."
        );
    }

    @Override
    public String toString(){
        return ("This is the added card amount for the player "+ playerTotal
                +"\nThis is the added card amount for the dealer "+ dealerTotal
                +"\nThis is the deck printed out\n" + deck);
    }
}
