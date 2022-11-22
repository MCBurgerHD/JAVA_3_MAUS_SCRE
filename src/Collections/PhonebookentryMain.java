package Collections;

import java.util.*;

/**
 * Created: 21.10.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class PhonebookentryMain {
    public static void main(String[] args) {
        List<PhonebookEntry> liste = new ArrayList<>();
        try {
            liste.add(new PhonebookEntry("0238274", "Ertl"));
            liste.add(new PhonebookEntry("002742123", "Sprecher"));
            liste.add(new PhonebookEntry("0018723653", "Peckek"));
            liste.add(new PhonebookEntry("+439828492", "Patru"));
            liste.add(new PhonebookEntry("+172628183", "Mohnl"));
            liste.add(new PhonebookEntry("+272764782", "Otahal"));
            liste.add(new PhonebookEntry("023827248274", "Plasek"));
        }
        catch (IllegalArgumentException e) {}

        Comparator<PhonebookEntry> comparator = Collections.reverseOrder(PhonebookEntry::compareTo);


        liste.sort(comparator);
        System.out.println(liste);
    }
}
