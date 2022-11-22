package Generics.Pair;

import java.util.LinkedList;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class PairMap<K, V> implements Map{
    LinkedList<Object> lst = new LinkedList<>();
    @Override
    public Object put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("key ist NULL!");
        }
        if (key == get(key)) {
            int index = lst.indexOf(key);
            lst.set(index, value);
            return key;
        }
        else {
        lst.add(value);
        return null;
        }
    }

    @Override
    public Object get(Object key) {
        return get(key);
    }

    @Override
    public int size() {
        return lst.size();
    }
}
