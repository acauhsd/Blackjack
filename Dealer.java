public class Dealer extends Player {
    public Dealer() {
        super("Dealer");
    }
    
    public void playTurn(Game game) {
        if (handTotal() < 17) {
            hit(game);
        } else {
            stay();
        }
    }
    
    public String toString() {
        return "Dealer's hand: ????? and "+this.hand.get(1);
    }
    
    public String actualHand() {
        String str = "Dealer's hand: ";
        for (int i=0; i<this.hand.size(); i++) {
            if (i == this.hand.size()-1) {
                str += "and ";
                str += this.hand.get(i).toString();
                str += ".";
            } else {
                str += this.hand.get(i).toString();
                str += ", ";
            }
        }
        return str;
    }
}