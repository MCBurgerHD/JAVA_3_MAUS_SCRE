package Generics.Bottle;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Bottle<T> {

    private T gertaenk;

    public boolean isEmpty() {
        return gertaenk == null;
    }

    public void fill(T content) {
        this.gertaenk = content;
    }

    public T empty() {
        if (isEmpty()) {
            return gertaenk;
        }
        else {
            return this.gertaenk = null;
        }
    }
}
