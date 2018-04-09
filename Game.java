import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Game {
    private Dealer dealer;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Deck deck = new Deck();
    private Scanner scan = new Scanner(System.in);
   
    public Game() {
        scan.useDelimiter("\n");
        deck.shuffle();
    }
    
    private void reset() {
        deck = new Deck();
        deck.shuffle();
    }
    
    public void addDealer(Dealer dealer) {
        this.dealer = dealer;
        players.add((Player)dealer);
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public Card drawCard() {
        return deck.deal();
    }
    
    public String getResponse(String prompt) {
        System.out.println(prompt);
        return scan.next();
    }
    
    public void initializePlay() {
        for (Player player : players) {
            if (player.getClass() != Dealer.class) {
                System.out.println(player.getName()+", how much would you like to bet? You have $"+player.getMoney()+".");
                player.bet(scan.nextInt(), this);
            }
        }
        for (Player player : players) {
            player.hit(this);
            player.hit(this);
        }
    }
    
    public void play() {
        initializePlay();
        boolean still_playing = true;
        while (still_playing) {
            still_playing = false;
            for (Player player : players) {
                if (player.getStillPlaying()) {
                    still_playing = true;
                    if (player.getClass() == Player.class) {
                        System.out.println();
                        System.out.println(dealer);
                        System.out.println(player);
                    }
                    player.playTurn(this);
                    System.out.println(player);
                    if (player.handTotal() > 21) {
                        player.bust();
                    }
                }
            }
        }
        System.out.println();
        System.out.println("The game is over!");
        for (Player player : players) {
            if (player.getClass() == Dealer.class) {
                System.out.println(((Dealer)player).actualHand());
            } else {
                System.out.println(player);
            }
        }
        determineWinners();
        reset();
    }
    
    public void determineWinners() {
        ArrayList<Player> winners = new ArrayList<Player>();
        for (Player player : players) {
            if (player.handTotal() == dealer.handTotal()) {
                player.updateWinnings(1);
            } else if (player.handTotal() == 21) {
                player.updateWinnings(3);
            } else if (dealer.handTotal() > 21 && player.handTotal() <= 21) {
                player.updateWinnings(2);
            } else if (player.handTotal() > dealer.handTotal() && player.handTotal() <= 21) {
                player.updateWinnings(2);
            } else {
                player.updateWinnings(0);
            }
        }
        for (Player player : players) {
            player.reset();
        }
    }
    
    public String toString() {
        String string = "";
        for (Player player : players) {
            if (player.getClass() == Player.class) {
                string += player.getName()+" has $"+player.getMoney()+".\n";
            }
        }
        return string;
    }
}