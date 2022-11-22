package Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created: 06.10.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Token {

    public static void main(String[] args) {
        List<String> list = getSortedStrings("resources/tokens1.txt", "resources/tokens2.txt");
        System.out.println(list);
    }

    public static Collection<String> getToken(String filename) {
        Set<String> set = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.useDelimiter("[\\s,\\.:;?!]+");
            while (scanner.hasNext()) {
                set.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    public static List<String> getSortedStrings(String firstFileLocation, String secondFileLocation) {
        Collection<String> firstCollection = getToken(firstFileLocation);
        Collection<String> secondCollection = getToken(secondFileLocation);
        firstCollection.retainAll(secondCollection);
        List<String> list = new LinkedList<>(firstCollection);
        Collections.sort(list);
        return list;
    }
}
