package Wasserstaende;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created: 21.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        WasserStandAnalyse wtest = new WasserStandAnalyse();
        Map<LocalDateTime, Integer> map = wtest.readFromFile("resources/Wasserstaende/Datei_Wasserstand_data_25268_W_MONTH.txt");
        System.out.println(map.size());
        System.out.println("Durchschnitt : " + wtest.average(WasserStandAnalyse.parseDate("15.06.2009 00:00"),
                WasserStandAnalyse.parseDate("13.07.2009 23:55")));
        Map<LocalDateTime, Integer> map2 = wtest.highest(WasserStandAnalyse.parseDate("15.06.2009 00:00"),
                WasserStandAnalyse.parseDate("13.07.2009 23:55"));
        System.out.println("Hoechstes Emelent : " + wtest.maxElement(map2.entrySet()));
        System.out.print("Das hoechste Element kommt " + map2.size() + " mal vor!");
        System.out.println();
        for (Map.Entry<LocalDateTime, Integer> element:map.entrySet()) {
            System.out.println(element);
        }
    }
}
