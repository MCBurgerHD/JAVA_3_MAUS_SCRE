package Datentaeger;

import Flugzeug.WertNegativException;

/**
 * Created: 15.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */

public class Datentraeger {
    private String titel;
    private double preis;
    private int megaByteGroesse;
    private int gesamtAnzahl;

    public Datentraeger() {
        this("", 0.0, 0);
    }

    public Datentraeger(String titel, double preis) {
        this(titel, preis, 700);
    }

    public Datentraeger(String titel, double preis, int megaByteGroesse) {
        this.titel = titel;
        if (preis < 0) {
            throw new WertNegativException();
        }
        this.preis = preis;
        this.megaByteGroesse = megaByteGroesse;
        gesamtAnzahl++;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        if (preis < 0) {
            throw new WertNegativException("Preis NEGATIV!");
        }
        this.preis = preis;
    }

    public int getMegaByteGroesse() {
        return megaByteGroesse;
    }

    @Override
    public String toString() {
        return "Titel : " + getTitel() + ", Preis : " + getPreis() + ", Speichergroesse : " + getMegaByteGroesse();
    }
}