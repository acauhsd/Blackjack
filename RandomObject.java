import java.util.Comparator;

public class RandomObject implements Comparator {
    public int compare(Object one, Object two) {
        return (int)Math.floor(Math.random() - 0.5);
    }
}