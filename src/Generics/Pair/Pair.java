package Generics.Pair;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Pair<T,U> {

    private T first;
    private U second;

    public Pair() {
    }

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public U getSecond() {
        return second;
    }

    public T getFirst() {
        return first;
    }

    public Pair flipped() {
        return new Pair<>(getSecond(), getFirst());
    }
}
