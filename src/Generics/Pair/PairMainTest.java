package Generics.Pair;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class PairMainTest {
    public static void main(String[] args) {
        Brot brot = new Brot();
        Wurst wurst = new Wurst();
        Pair<Brot, Wurst> wurstbrot = new Pair<>(brot, wurst);
        Brot brotRet = wurstbrot.getFirst(); // == brot
        Wurst wurstRet = wurstbrot.getSecond(); // == wurst
        Pair<Integer, String> pair = new Pair<>(3, "if");
        Pair <String, Integer> flipped = pair.flipped ();
//      flipped.getSecond() == pair.getFirst(); // true
    }
}
