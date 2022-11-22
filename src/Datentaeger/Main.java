package Datentaeger;

import Flugzeug.WertNegativException;

import java.util.Scanner;

/**
 * Created: 15.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Main {
    public static void main(String[] args) {
        Datentraeger cd = new CD("Die besten Hits", 15.99, 1000 ,true);
        Datentraeger dvd = new DVD("John Wick 3", 19.99, 5000, '+');

        System.out.println(cd.toString());
        System.out.println(dvd.toString());

        dvd.setTitel("Der unglaubliche Hulk");
        System.out.println();
        System.out.println(dvd.toString());
        try {
            cd.setPreis(-13);
        } catch (WertNegativException w) {
            System.out.println("Wert NEGATIV!");
        }

        System.out.println();
        System.out.print("Eingabe : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

//        System.out.print("Preis : ");
//        Scanner scanner2 = new Scanner(System.in);
//        double preis = scanner.nextDouble();
//        System.out.print("Speichergroesse : ");
//        Scanner scanner3 = new Scanner(System.in);
//        int megaByteGroesse = scanner.nextInt();

        String[] strSplit = str.split(":");
        String title = strSplit[0];
        double preis = Double.parseDouble(strSplit[1]);
        int megaByteGroesse = Integer.parseInt(strSplit[2]);
        /*
        } try {

        }
        catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Ungueltig! Nochmal eingeben!");
        }*/
        Datentraeger datentraeger = new Datentraeger(title, preis, megaByteGroesse);
        System.out.println(datentraeger.toString());
    }
}
