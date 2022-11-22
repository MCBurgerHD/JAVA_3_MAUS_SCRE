package CollectionII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created: 09.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class UniqueCharacterMap {
    private static HashMap<String, Integer> hashMap = new HashMap<>();

    public static int getUniqueChars(String str) {
        if (!hashMap.containsKey(str)) {
            Set<Character> uniqueSet = new HashSet<>();
            for (char i : str.toCharArray()) {
                uniqueSet.add(i);
            }
            hashMap.put(str, uniqueSet.size());
            return uniqueSet.size();
        }
        return hashMap.get(str);
    }

    public static void main(String[] args) {
        System.out.println(getUniqueChars("abcdefgh"));
        System.out.println(getUniqueChars("abcdefgh"));
        System.out.println(getUniqueChars("Hallo"));
        System.out.println(getUniqueChars("Hallo"));
        System.out.println(getUniqueChars("test"));
    }
}
