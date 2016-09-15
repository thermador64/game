/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Agent {

    int card1;
    int card2;
    int card3;
    int card1Value;
    int card2Value;
    int card3Value;
    int spades;
    int hearts;
    int diamonds;
    int clubs;
    char getSuit;

    public int exchangeOrDrop(int card) {
        int eod = 0;
        int initValue = getTotal();
        int change1 = 0;
        if(determineSuit(card) == getSuit){
            change1 += determineValue(card);
        }
        if(determineSuit(card2) == getSuit){
            change1 += card2Value;
        }
        if(determineSuit(card3) == getSuit){
            change1 += card3Value;
        }
        int change2 = 0;
        if(determineSuit(card) == getSuit){
            change2 += determineValue(card);
        }
        if(determineSuit(card1) == getSuit){
            change2 += card1Value;
        }
        if(determineSuit(card3) == getSuit){
            change2 += card3Value;
        }
        int change3 = 0;
        if(determineSuit(card) == getSuit){
            change3 += determineValue(card);
        }
        if(determineSuit(card2) == getSuit){
            change3 += card2Value;
        }
        if(determineSuit(card1) == getSuit){
            change3 += card1Value;
        }

        if (initValue > change1 && initValue > change2 && initValue > change3) {
            eod = 4;
        }
        if (change1 > initValue && change1 >= change2 && change1 >= change3) {
            eod = 1;
        }
        if (change2 >= change1 && change2 > initValue && change2 >= change3) {
            eod = 2;
        }
        if (change3 > initValue && change3 >= change2 && change3 >= change1) {
            eod = 3;
        }

        return eod;
    }

    public int determineAction1(int sCard, boolean knock) {
        int action = 0;
        
        if (!knock && getTotal() > 25) {
            return 8;
        }
        if (determineSuit(sCard) == getSuit) {
            action = exchangeOrDrop(sCard);
            if (action < 4) {
                return action;
            }
        }
        if (knock && getTotal() > 25) {
            return 9;
        }
        return 4;
    }

    public int determineAction2(int dCard) {
        int action = 0;

        if (determineSuit(dCard) == getSuit) {
            action = exchangeOrDrop(dCard);
            if (action < 4) {
                return action + 3;
            } else {
                return 7;
            }
        } else {
            return 7;
        }
    }

    public void findGetSuit() {
        spades = 0;
        hearts = 0;
        diamonds = 0;
        clubs = 0;

        if (determineSuit(card1) == 's') {
            spades += determineValue(card1);
        }
        if (determineSuit(card1) == 'h') {
            hearts += determineValue(card1);
        }
        if (determineSuit(card1) == 'd') {
            diamonds += determineValue(card1);
        }
        if (determineSuit(card1) == 'c') {
            clubs += determineValue(card1);
        }

        if (determineSuit(card2) == 's') {
            spades += determineValue(card2);
        }
        if (determineSuit(card2) == 'h') {
            hearts += determineValue(card2);
        }
        if (determineSuit(card2) == 'd') {
            diamonds += determineValue(card2);
        }
        if (determineSuit(card2) == 'c') {
            clubs += determineValue(card2);
        }

        if (determineSuit(card3) == 's') {
            spades += determineValue(card3);
        }
        if (determineSuit(card3) == 'h') {
            hearts += determineValue(card3);
        }
        if (determineSuit(card3) == 'd') {
            diamonds += determineValue(card3);
        }
        if (determineSuit(card3) == 'c') {
            clubs += determineValue(card3);
        }

        if (spades >= hearts && spades >= diamonds && spades >= clubs) {
            getSuit = 's';
        }
        if (hearts >= spades && hearts >= diamonds && hearts >= clubs) {
            getSuit = 'h';
        }
        if (diamonds >= spades && diamonds >= hearts && diamonds >= clubs) {
            getSuit = 'd';
        }
        if (clubs >= spades && clubs >= hearts && clubs >= diamonds) {
            getSuit = 'c';
        }
    }

    public int determineValue(int card) {
        int value = 0;
        if (card == 1 || card == 14 || card == 27 || card == 40) {
            value = 11;
        }
        if (card == 2 || card == 15 || card == 28 || card == 41) {
            value = 10;
        }
        if (card == 3 || card == 16 || card == 29 || card == 42) {
            value = 10;
        }
        if (card == 4 || card == 17 || card == 30 || card == 43) {
            value = 10;
        }
        if (card == 5 || card == 18 || card == 31 || card == 44) {
            value = 10;
        }
        if (card == 6 || card == 19 || card == 32 || card == 45) {
            value = 9;
        }
        if (card == 7 || card == 20 || card == 33 || card == 46) {
            value = 8;
        }
        if (card == 8 || card == 21 || card == 34 || card == 47) {
            value = 7;
        }
        if (card == 9 || card == 22 || card == 35 || card == 48) {
            value = 6;
        }
        if (card == 10 || card == 23 || card == 36 || card == 49) {
            value = 5;
        }
        if (card == 11 || card == 24 || card == 37 || card == 50) {
            value = 4;
        }
        if (card == 12 || card == 25 || card == 38 || card == 51) {
            value = 3;
        }
        if (card == 13 || card == 26 || card == 39 || card == 52) {
            value = 2;
        }
        return value;
    }

    public char determineSuit(int card) {
        char suit = 'e';
        if (card < 14) {
            suit = 's';
        }
        if (card > 13 && card < 27) {
            suit = 'h';
        }
        if (card > 26 && card < 40) {
            suit = 'd';
        }
        if (card > 39) {
            suit = 'c';
        }
        return suit;
    }

    public int getTotal() {
        int total = 0;

        if(determineSuit(card1) == getSuit){
            total += card1Value;
        }

        if(determineSuit(card2) == getSuit){
            total += card2Value;
        }
 
        if(determineSuit(card3) == getSuit){
            total += card3Value;
        }
        return total;
    }

    public int getCard1() {
        return card1;
    }

    public int getCard2() {
        return card2;
    }

    public int getCard3() {
        return card3;
    }

    public void setCard1(int card) {
        card1 = card;
    }

    public void setCard2(int card) {
        card2 = card;
    }

    public void setCard3(int card) {
        card3 = card;
    }

    public void setCardValues() {
        card1Value = determineValue(card1);
        card2Value = determineValue(card2);
        card3Value = determineValue(card3);
    }
}
