package Flugzeug;

/**
 * Created: 08.09.2022
 *
 * @author Maximilian Ertl (Maximilian Ertl)
 */

public class FlugzeugMain {
    public static void main(String[] args) {
        Flugzeug f1 = new Militaerflugzeug("Northrop B-2", 2000000.12, 4, true);
        Flugzeug f2 = new Verkehrsflugzeug("Boeing 747", 234000.83, 4, 371);

        System.out.println("Bezeichnung : " + f1.getBezeichnung() + ", " + "Preis : " +f1.getPreis() +
        ", " + "Triebwerkanzahl : " + f1.getTriebwerkanzahl() + ", " + "Stealth Technik : " +
        ((Militaerflugzeug) f1).getStealthTechnik());

        System.out.println("Bezeichnung : " + f2.getBezeichnung() + ", " + "Preis : " +f2.getPreis() +
                ", " + "Triebwerkanzahl : " + f2.getTriebwerkanzahl() + ", " + "Passagieranzahl : " +
                ((Verkehrsflugzeug) f2).getPassagierAnzahl());

        f2.setBezeichnung("Airbus A320");
        ((Verkehrsflugzeug) f2).setPassagierAnzahl(234);

//      f1.setPreis(-1);

        Flugzeug[] flugzeuge = new Flugzeug[30];

        for (int i = 0; i < 30; i++) {
            double random = Math.random();
            if (random <0.5) {
                flugzeuge[i] = new Militaerflugzeug();
            }
            else {
                flugzeuge[i] = new Verkehrsflugzeug();
            }
        }

        int militaer = 0;
        int verkehr = 0;

        for (int i = 0; i < flugzeuge.length; i++) {
            if (flugzeuge[i] instanceof Militaerflugzeug) {
                militaer++;
            }
            if (flugzeuge[i] instanceof Verkehrsflugzeug) {
                verkehr++;
            }
        }

        System.out.println(militaer + " Militaerflugzeuge und " + verkehr + " Verkehrsflugzeuge");
    }
}
