package GenericUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created: 13.10.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public final class GenericUtil {

    private GenericUtil() {
    }

    public static <T> void printArray(T [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }

    public static <T extends Number> double sum(T [] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].doubleValue();
        }
        return sum;
    }

   public static <T extends Comparable<T>> T maxElement(Collection<T> collection) {
        if (collection.size() == 0) {
            throw new IllegalArgumentException("Array laenge kleiner 0!");
        }
        T max = null;
       for (T value: collection) {
           if (max == null) {
               max = value;
           }
           if (value.compareTo(max) > 0) {
               max = value;
           }
       }
       return max;
   }

    public static <T extends Number> int countOdds(Collection<T> collection) {
        int count = 0;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection leer!");
        }
        for (T value: collection) {
            if (value.intValue() % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static <T extends Comparable<T>> void swapElements(List<T> list, int index1, int index2) {
        if (list.get(index1).compareTo(list.get(index2)) > 0) {
            T elementI1 = list.get(index1);
            T elementI2 = list.get(index2);
            list.set(index1, elementI2);
            list.set(index2, elementI1);
        }
    }
    public static <T extends Number> T max(T a, T b) {
        if(a.doubleValue() > b.doubleValue()){
            return a;
        }
        return  b;
    }

    public static <T extends Integer> List<T> makeList(Class<T> classType, int anzahl) {
        List<Integer> ergebnis = new ArrayList<>();
        for (int i = 0; i < anzahl; i++) {
            double random = Math.random();
            if (classType.isInstance(classType)) {
                if (random < 0.5) {
                    ergebnis.add(5);
                }
                if (random >= 0.5) {
                    ergebnis.add(25);
                }
            }
            else {
                if (random < 0.5) {
                    ergebnis.add(50);
                }
                if (random >= 0.5) {
                    ergebnis.add(100);
                }
            }
        }
        return (List<T>) ergebnis;
    }

    public static <T> List<T> grenzwertMethode(List<T> list, int grenzwert) {
        if (list.size() < 0) {
            throw new IllegalArgumentException("Liste Leer!");
        }
        List<T> ergebnis = new ArrayList<T>();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(grenzwert+1)) {
                ergebnis.add(index, list.get(i));
            }
        }
        return ergebnis;
    }
}
