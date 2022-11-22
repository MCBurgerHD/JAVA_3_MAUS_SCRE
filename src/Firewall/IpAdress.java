package Firewall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created: 11.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class IpAdress implements Comparable<IpAdress>{
    private String adresse;

    public IpAdress(String adresse) {
        if (adresse == null || adresse.isEmpty()) {
            throw new IllegalArgumentException("IP Adresse ist ungültig!");
        }
        setAdress(adresse);
    }

    private void setAdress(String adresse) {
        if (adresse.contains(":")) {
            adresse = adresse.substring(0, adresse.indexOf(":"));
        }

        try {
            String[] splittedString = adresse.split("\\.");
            for (String s : splittedString) {
                if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255 || splittedString.length != 4) {
                    throw new IllegalArgumentException("IP Adresse ist ungueltig!");
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("IP Adresse ist ungueltig!");
        }
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public int compareTo(IpAdress o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IpAdress adr = (IpAdress) o;
        return Objects.equals(this.adresse, adr.adresse);
    }

    @Override
    public int hashCode() {
        return this.adresse != null ? this.adresse.hashCode() : 0;
    }

    public String toString() {
        return this.getAdresse();
    }

    public static Map<IpAdress, Set<IpAdress>> getAdressesFromFile(String path) throws FileNotFoundException {
        Map<IpAdress, Set<IpAdress>> map = new HashMap<>();
        try (Scanner scan = new Scanner(new File(path))) {
            scan.nextLine();
            String[] s;
            while (scan.hasNext()) {
                s = scan.nextLine().split(" ");
                s[1] = s[1].split(":")[0];
                IpAdress ip = new IpAdress(s[0]);
                IpAdress key = new IpAdress(s[1]);
                if (map.containsKey(key)) {
                    map.get(key).add(ip);
                } else {
                    Set<IpAdress> set = new TreeSet<>();
                    set.add(ip);
                    map.put(key, set);
                }
            }
        }
        return map;
    }


    public static void printIpAdresses(String path) throws FileNotFoundException {
        Map<IpAdress, Set<IpAdress>> map = getAdressesFromFile(path);
        Set<IpAdress> keys = map.keySet();

        for (IpAdress key : keys) {
            System.out.println(key);
            for (IpAdress ipAdresse : map.get(key)) {
                System.out.println("\t" + ipAdresse);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        try {
            printIpAdresses("resources/Firewall/Firewall.txt");
        } catch (Exception e) {
            System.out.println("Fehlermedlung : " + e);
        }
    }
}
