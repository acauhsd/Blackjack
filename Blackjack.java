import java.util.Scanner;
import java.util.InputMismatchException;

public class Blackjack {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        Game game = new Game();
        
        System.out.println("How many players?");
        int player_count = scan.nextInt()+1;
                
        game.addDealer(new Dealer());
        for (int i=1; i<player_count; i++) {
            System.out.println("Player "+i+"'s name?");
            game.addPlayer(new Player(scan.next()));
        }
        
        String keep_playing_response = "y";
        while (keep_playing_response.length() > 0 && keep_playing_response.charAt(0) == 'y') {
            System.out.println();
            game.play();
            System.out.println();
            System.out.println(game); // game has /n at the end
            System.out.println("Should the game continue? (Yes/No)");
            keep_playing_response = scan.next();
        }
    }
}