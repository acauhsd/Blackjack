public class FaceCard extends Card {
    private String face;
    
    public static final String[] faces = {"Jack","Queen","King"};
    
    public FaceCard(String face, String suit) {
        super(10, suit);
        this.face = face;
    }
    
    public String toString() {
        return this.face+" of "+this.getSuit();
    }
}