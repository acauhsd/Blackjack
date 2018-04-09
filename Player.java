import java.util.ArrayList;

public class Player {
    private String name;
    private int money = 100;
    private int bet = 0;
    protected ArrayList<Card> hand = new ArrayList<Card>();
    private boolean still_playing = true;
    
    public Player(String name) {
        this.name = name;
    }
    
    public void reset() {
        this.bet = 0;
        this.hand = new ArrayList<Card>();
        this.still_playing = true;
    }
    
    public void bet(int amount, Game game) {
        this.money -= Math.min(Math.max(amount, 0), this.money);
        this.bet = amount;
    }
    
    public void playTurn(Game game) {
        String response = game.getResponse(this.name+": Hit or stay?").toLowerCase();
        if (response.length() > 0 && response.charAt(0) == 'h') {
            hit(game);
        } else {
            stay();
        }
    }
    
    public void hit(Game game) {
        hand.add(game.drawCard());
    }
    
    public void stay() {
        this.still_playing = false;
    }
    
    public void bust() {
        this.still_playing = false;
    }
    
    public void updateWinnings(double factor) {
        this.money += factor*this.bet;
    }
    
    public int handTotal() {
        int total = 0;
        for (int i=0; i<hand.size(); i++) {
            total += hand.get(i).getValue();
        }
        if (total > 21) {
            Ace soft_ace = null;
            for (int i=0; i<hand.size(); i++) {
                if (hand.get(i).getValue() == 11) {
                    soft_ace = (Ace)hand.get(i);
                    break;
                }
            }
            if (soft_ace != null) {
                soft_ace.preventBust();
                return handTotal();
            }
        }
        return total;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getMoney() {
        return this.money;
    }
    
    public boolean getStillPlaying() {
        return this.still_playing;
    }
    
    public String toString() {
        String str = this.name+"'s hand: ";
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