public class Ace extends Card {
    public Ace(String suit) {
        super(11, suit);
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void preventBust() {
        this.value = 1;
    }
    
    public String toString() {
        return "Ace of "+this.getSuit();
    }
}