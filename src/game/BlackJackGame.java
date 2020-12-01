/**
 * This class represents a game of Black Jack
 * The objective is to get as close to 21 as possible without going over
 * Whoever gets closest to 21 without going over wins
 *
 * @author Ben Chadwick
 * @version 1.0
 * created on 11/17/2020
 */

package game;

import cards.StandardCard;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BlackJackGame {

    // fields
    private static final String DEALER = "dealer", PLAYER = "player";
    private static final int BLACKJACK = 21;
    private static BlackJack game;

    public static void main(String[] args){
        game = new BlackJack();
        boolean hit;
        Scanner in = new Scanner(System.in);
        List<StandardCard> playerHand;
        List<StandardCard> dealerHand;

        do {
            // Give each hand two cards from initial deal, then sum by passing their respective method
            cardSum(playerHand = initialDeal(), game::setPlayerTotal);
            cardSum(dealerHand = initialDeal(), game::setDealerTotal);

            System.out.println(printInitialDeal(playerHand, PLAYER));
            // Don't allow the player to hit if they get a 21 on the first two cards
            if(game.getPlayerTotal() == BLACKJACK)
                System.out.println(stopHit(PLAYER));
            else {
                hit = playerHit(in);
                while (hit) {
                    playerHand.add(game.dealOneCard());
                    cardSum(playerHand, game::setPlayerTotal);
                    System.out.println(printLastDealt(playerHand));
                    // if the player landed on 21 or busted, halt turn, otherwise prompt to hit
                    hit = game.getPlayerTotal() >= BLACKJACK ? stopHit(PLAYER) : playerHit(in);
                }
            }

            System.out.println(printInitialDeal(dealerHand, DEALER) +"\nThe dealer's total is "+ game.getDealerTotal());
            do {
                // the logic of the dealer is to hit if the player is higher but not if the player went bust
                if (game.getDealerTotal() < game.getPlayerTotal() && !(game.getPlayerTotal() > BLACKJACK)) {
                    hit = true;
                    dealerHand.add(game.dealOneCard());
                    cardSum(dealerHand, game::setDealerTotal);
                    System.out.println("The dealer chose to hit...\n"+ printLastDealt(dealerHand)
                    +"\nThe dealer's total is "+ game.getDealerTotal());
                } else
                    hit = stopHit(DEALER);
            } while(hit);

            System.out.print(printWinner() + "Do you want to play again?: ");
        } while(in.nextBoolean());
    }

    /**
     * initialDeal deals two cards to a reference List
     * @return the two cards in a List interface
     * */
    private static List<StandardCard> initialDeal(){return game.dealTwoCards().collect(Collectors.toList());}

    /**
     * printInitialDeal prints the first dealt cards for the given player
     * @param hand is the List of StandardCard's being passed in for a particular player
     * @param player represents either the dealer or user playing
     * @return the String that represents the first dealt cards
     */
    private static String printInitialDeal(List<StandardCard> hand, String player){
        return hand.stream().map(c ->  "\n" + (player == DEALER ? "The dealer was dealt a " : "You were dealt a ") + c)
                .collect(Collectors.joining());
    }

    /**
     * printLastDealt prints the last card inserted into the hand
     * @param hand is the StandardCard's the player currently possesses
     * @return the String that represents the last StandardCard that was dealt
     */
    private static String printLastDealt(List<StandardCard> hand){return "The deck dealt a " + hand.get(hand.size()-1);}

    /**
     * cardSum adds all the cards in the hand together and stores the sum
     * @param hand is the List of StandardCard's being passed in for a particular player
     * @param method is either game.setPlayerTotal() or game.setDealerTotal dependant on the player called
     */
    private static void cardSum(List<StandardCard> hand, Consumer<Integer> method){
        method.accept(hand.stream().mapToInt(c -> c.getRankValue()).sum());
    }

    /**
     * stopHit halts the option to get another card, conditions being blackjack or bust
     * @param player represents either the dealer or user playing
     * @return false because the player's turn is halted after this method gets called
     */
    private static boolean stopHit(String player){
        if(player == DEALER) {
            if (game.getDealerTotal() > 21) System.out.println("Dealer went bust...");
        }
        else if(player == PLAYER) {
            System.out.println(game.getPlayerTotal() == 21 ? "You got a Black Jack! (21)" : "You went bust...");
        }
        return false;
    }

    /**
     * playerHit prompts the user playing to hit or hold, represented as True or False
     * @param in is the Scanner object that takes in the boolean value from the user
     * @return the boolean from the user is returned
     */
    private static boolean playerHit(Scanner in){
        System.out.print("Your total is "+ game.getPlayerTotal() +", hit?: ");
        return in.nextBoolean();
    }

    /**
     * printWinner tests whether the Dealer won or the User won
     * @return the String that shows who the winner is
     */
    private static String printWinner(){
        if(game.getDealerTotal() > 21) return "\nYou won!!!\n";
        else if(game.getPlayerTotal() != game.getDealerTotal()) return "\nThe dealer won...\n";
        else return "\nIt was a tie.\n";
    }
}