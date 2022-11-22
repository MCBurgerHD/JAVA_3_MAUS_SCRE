package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created: 21.10.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Student {
    private String vorname;
    private String nachname;
    private int matrikelnummer;
    static Collection<Integer> collection = new  ArrayList<>();

    public Student(String vorname, String nachname, int matrikelnummer) {
        if (collection.contains(matrikelnummer)) {
            throw new IllegalArgumentException("Matrikelnummer bereits verwendet!");
        }
        if (Objects.equals(vorname, "")) {
            throw new IllegalArgumentException("Vorname LEER!");
        }
        if (nachname == "") {
            throw new IllegalArgumentException("Nachname LEER!");
        }
        if (vorname != null) {
            this.vorname = vorname;
        }
        if (nachname != null) {
            this.nachname = nachname;
        }
        if (matrikelnummer > 0) {
            this.matrikelnummer = matrikelnummer;
            collection.add(matrikelnummer);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    @Override
    public String toString() {
        return getVorname() + ", " + getNachname() + ", " + "(" + getMatrikelnummer() + ")";
    }

    public static void main(String[] args) {
        Student student1 = new  Student("Muster", "Thomas", 123456);
        Student student2 = new  Student("Herbert", "Franz", 111111);
        Student student3 = new  Student("Malt", "David R.", 323232);


        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        try {
            Student s1 = new  Student("", "", 111111);
        }
        catch (IllegalArgumentException e){
            System.out.println("Ungueltige angabe!");
        }
    }
}
