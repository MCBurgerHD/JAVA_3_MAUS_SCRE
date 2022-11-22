package CollectionII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created: 03.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Euler539 {
    public static void removeElement(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
    }
    public static int p(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        while(list.size() > 1) {
            removeElement(list);
            Collections.reverse(list);
        }

        return list.get(0);
    }
    public static int s(int n) {
        int ret = 0;

        for (int i = 1; i <= n; i++) {
            ret += p(i);

        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(p(1000));
        System.out.println(s(1000));
    }
}
