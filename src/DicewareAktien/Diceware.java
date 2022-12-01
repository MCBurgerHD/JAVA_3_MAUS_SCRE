package DicewareAktien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created: 24.11.2022
 *
 * @author Maximilian Ertl (maxer)
 *
 */
public class Diceware {
    public static void main(String[] args) {
        try {
            System.out.println("German");
            Map<Integer, String> map = diceWarePaare("resources/DicewareAktien/diceware_german.txt");
            System.out.println(diceWarePasswd(map));
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        System.out.println();
        try {
            System.out.println("English");
            Map<Integer, String> map = diceWarePaare("resources/DicewareAktien/diceware_english.txt");
            System.out.println(diceWarePasswd(map));
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

    private static final Random random = new Random();

    public static String diceWarePasswd(Map<Integer, String> map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int nummer = 0;
            for (int j = 0; j < 5; j++) {
                nummer *= 10;
                nummer += random.nextInt(5) + 1;
            }
            sb.append(map.get(nummer)).append("\n");
        }
        return sb.toString();
    }

    public static Map<Integer, String> diceWarePaare(String dateiName) throws IOException {
        if (dateiName == null) {
            throw new IllegalArgumentException("Dateiname unguetig!");
        }
        Map<Integer, String> map = new TreeMap<>();

        if (dateiName.contains("german")) {
            try (BufferedReader br = new BufferedReader(new FileReader(dateiName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] splited = line.split("\\s");
                    if (splited.length != 2) continue;
                    int i;
                    try {
                        i = Integer.parseInt(splited[0]);
                        int cpy = i;
                        int len = 0;
                        while (cpy > 0) {
                            int zif = cpy % 10;
                            if (zif < 1 || zif > 6) {
                                continue;
                            }
                            cpy = cpy / 10;
                            len++;
                        }
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    map.put(i, line);
                }
            }
        }
        if (dateiName.contains("english")) {
            try (BufferedReader br = new BufferedReader(new FileReader(dateiName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] splited = line.split("\\t");
                    if (splited.length != 2) continue;
                    int i;
                    try {
                        i = Integer.parseInt(splited[0]);
                        int cpy = i;
                        int len = 0;
                        while (cpy > 0) {
                            int zif = cpy % 10;
                            if (zif < 1 || zif > 6) {
                                continue;
                            }
                            cpy = cpy / 10;
                            len++;
                        }
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    map.put(i, line);
                }
            }
        }
        return map;
    }
}
