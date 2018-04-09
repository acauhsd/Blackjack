import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
        for (String suit : Card.suits) {
            cards.add(new Ace(suit));
            for (int value : Card.values) {
                cards.add(new Card(value, suit));
            }
            for (String face : FaceCard.faces) {
                cards.add(new FaceCard(face, suit));
            }
        }
    }
    
    public void shuffle() {
        cards.sort(new RandomObject());
    }
    
    public Card deal() {
        Card to_deal = cards.get(0);
        cards.remove(0);
        return to_deal;
    }
    
    public String toString() {
        String str = "Deck contains: [";
        for (int i=0; i<this.cards.size(); i++) {
            str += this.cards.get(i).toString();
            if (i == this.cards.size()-1) {
                str += "]";
            } else {
                str += ", ";
            }
        }
        return str;
    }
}