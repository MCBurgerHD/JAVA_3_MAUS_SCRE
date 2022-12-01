package DicewareAktien;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created: 24.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Aktien {

    private int geld = 100000;
    private List<Aktie> aktien = new ArrayList<>();

    public List<Aktie> readFormFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String [] splitted = line.split(",");
                if (Objects.equals(splitted[1], "")) {
                    aktien.add(new Aktie(splitted[0], 0, Integer.parseInt(splitted[2])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("404 File not Found!");
        }
        return aktien;
    }

    public List<Aktie> invest(List<Aktie> aktien) {
        List<Aktie> investierteAktien = new ArrayList<>();
        double shares = 0;
        for (int i = 0; i < aktien.size(); i++) {
            shares = aktien.get(i).getPreis() * 0.2;
            shares = Math.round(shares);
            investierteAktien.add(new Aktie(bestPriceAndRating(aktien).getName(), bestPriceAndRating(aktien).getRating(),
                    bestPriceAndRating(aktien).getPreis(), (int) shares));
        }
        return investierteAktien;
    }

    public Aktie bestPriceAndRating(List<Aktie> akktien) {
        String name = "";
        int bestRating = 0;
        int betsPrice = 0;
        for (int i = 0; i < akktien.size(); i++) {
            if (bestRating < akktien.get(i).getRating() && betsPrice > akktien.get(i).getPreis()) {
                name = akktien.get(i).getName();
                bestRating = akktien.get(i).getRating();
                betsPrice = akktien.get(i).getPreis();
            }
        }
        return new Aktie(name, bestRating, betsPrice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aktien.size(); i++) {
            sb.append(aktien.get(i).getName() + " : " + aktien.get(i).getShares());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Aktien aktien = new Aktien();
        List<Aktie> liste = aktien.readFormFile("resources/DicewareAktien/stocks.csv");
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i).toString());
        }
    }
}
