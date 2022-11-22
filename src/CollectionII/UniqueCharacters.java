package CollectionII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 03.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class UniqueCharacters {

    public static List<Counts> liste = new ArrayList<>();

    public static int getUniqueChars(String str) {
        int counts = 0;
        for (int i = 0; i < str.length(); i++) {
            if (liste.contains(str)) {
                int index = liste.indexOf(str);
                return liste.get(index).getDifferentChars();
            }
            else {
                liste.add(new Counts(str, 1));
                counts++;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(getUniqueChars("abcdefgh"));
        System.out.println(getUniqueChars("abcdefgh"));
        System.out.println(getUniqueChars("Hallo"));
        System.out.println(getUniqueChars("Hallo"));
        System.out.println(getUniqueChars("test"));
    }
}
