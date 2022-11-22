package Flugzeug;

/**
 * Created: 08.09.2022
 *
 * @author Maximilian Ertl (Maximilian Ertl)
 */


public class Flugzeug {
    private String bezeichnung;
    private double preis;
    private int triebwerkanzahl;
    private static int flugzeugAnzahl = 0;

    public Flugzeug() {
    }

    public Flugzeug(String bezeichnung, double preis) {
        this(bezeichnung, preis, 2);
    }

    public Flugzeug(String bezeichnung, double preis, int triebwerkanzahl) {
        this.bezeichnung = bezeichnung;
        if (preis < 0) {
            throw new WertNegativException("Preis NEGATIV!");
        }
        this.preis = preis;
        if (triebwerkanzahl < 0) {
            throw new WertNegativException("Triebwerkanzahl NEGATIV!");
        }
        this.triebwerkanzahl = triebwerkanzahl;
        flugzeugAnzahl++;
    }

    public static void anazahlWirdUmEinsReduziert() {
        if (flugzeugAnzahl != 0) {
            flugzeugAnzahl--;
        }
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

    public int getTriebwerkanzahl() {
        return triebwerkanzahl;
    }

    public static int getFlugzeugAnzahl() {
        return flugzeugAnzahl;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setPreis(double preis) {
        if (preis < 0) {
            throw new WertNegativException("Preis NEGATIV");
        }
        this.preis = preis;
    }
}