package Firewall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created: 10.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class IPAdress_old {

    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        String line;
        String quelle;
        String ziel;
        String port;

        try {
            Scanner fileScanner = new Scanner(new File("resources\\Firewall\\Firewall.txt"));
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                line = fileScanner.next();
                quelle = line.split(" ")[0];
                ziel = line.split(" ")[1].split(":")[1];
                port = line.split(":")[1];
                if (quelle.split("\\.").length != 4) {
                    throw new IllegalArgumentException();
                }
                if (ziel.split("\\.").length != 4) {
                    throw new IllegalArgumentException();
                }
                if (Integer.parseInt(port) < 0) {
                   throw new IllegalArgumentException();
                }
                if (Integer.parseInt(ziel) < 0) {
                    throw new IllegalArgumentException();
                }
                if (Integer.parseInt(quelle) < 0) {
                    throw new IllegalArgumentException();
                }
                else {
                    map.put(quelle, ziel);
                }
            }
        }
        catch (IllegalArgumentException i) {
            System.out.println("Angegebene Adressen ungueltig!");
        }
        catch (FileNotFoundException f) {
            System.out.println("Datei nicht gefunden!");
        }
    }
}