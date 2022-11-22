package Wasserstaende;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created: 17.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class WasserStandAnalyse {

    NavigableMap<LocalDateTime, Integer> levels = new TreeMap<>();

    public static LocalDateTime parseDate(String date) {
        /*String pattern = "yyyy-MM-dd";
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime time = LocalDateTime.parse(startDate, df);
        return time;*/
        try {
            String pattern = "dd.MM.uuuu HH:mm";
            DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
            LocalDateTime time = LocalDateTime.parse(date, df);
            return  time;
        }
        catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public Map<LocalDateTime, Integer> readFromFile(String fileName) throws IOException {
        Map<LocalDateTime, Integer> map = new TreeMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            String zeile;
            while (scanner.hasNext()) {
                zeile = scanner.nextLine();
                if (zeile.matches("[0-9]+.[0-9]+.[0-9]+\\s[0-9]+:[0-9]+\\t[0-9]+.[0-9]+.[0-9]+\\s[0-9]+:[0-9]+\\t[0-9]*" +
                        "\\sU\\tungeprueft")) {
                    String[] strings = zeile.split("\t");
                    LocalDateTime time = parseDate(strings[0]);
                    int level = Integer.parseInt(strings[2]);
                    if (level < 0) {
                        throw new IOException();
                    }
                    map.put(time, level);
                    levels.put(time, level);
                }
            }
        }
        catch (IOException i) {
            System.out.println("Level NEGATIV!");
        }
        return map;
    }

    public Map<LocalDateTime, Integer> highest(LocalDateTime from, LocalDateTime to) {
        Map<LocalDateTime, Integer> map = new TreeMap<>();
        SortedMap<LocalDateTime, Integer> sortedMap = levels.subMap(from, to);
        int stand = 0;
        int groeser = 0;
        LocalDateTime groessteZeit;
        for (Map.Entry<LocalDateTime, Integer> entry : sortedMap.entrySet()) {
            if (entry.getValue() > groeser) {
                map.clear();
                groeser = entry.getValue();
                map.put(entry.getKey(), entry.getValue());
            }

            if (entry.getValue() >= groeser) {
                groeser = entry.getValue();
                map.put(entry.getKey(), entry.getValue());
            }

        }
        return map;
    }

    public double average(LocalDateTime from, LocalDateTime to) {
        double average = 0;
        double sum = 0;
        SortedMap<LocalDateTime, Integer> sortedMap = levels.subMap(from, to);
        for (Map.Entry<LocalDateTime, Integer> enty: sortedMap.entrySet()) {
            sum = enty.getValue();
        }
        average = sum / sortedMap.size();

        return average;
    }

    public int maxElement(Set<Map.Entry<LocalDateTime, Integer>> set) {
        int max = 0;

        for (Map.Entry<LocalDateTime, Integer> element: set) {
            if (element.getValue() > max) {
                max = element.getValue();
            }
        }
        return  max;
    }
}
