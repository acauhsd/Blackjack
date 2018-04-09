import java.util.Comparator;

public class Card implements Comparator<Card> {
    protected int value;
    private String suit;
    
    public static final int[] values = {2,3,4,5,6,7,8,9,10};
    public static final String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
    
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public String getSuit() {
        return this.suit;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String toString() {
        return this.value+" of "+this.suit;
    }
    
    public int compare(Card one, Card two) {
        return (int)Math.floor(Math.random() - 0.5);
    }
}