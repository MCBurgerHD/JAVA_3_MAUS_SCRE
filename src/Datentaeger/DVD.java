package Datentaeger;

/**
 * Created: 15.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class DVD extends Datentraeger{
    private char plusOderMinus;

    public DVD() {
        super();
    }

    public DVD(String titel, double preis, char plusOderMinus) {
        super(titel, preis);
        this.plusOderMinus = plusOderMinus;
    }

    public DVD(String titel, double preis, int megaByteGroesse, char plusOderMinus) {
        super(titel, preis, megaByteGroesse);
        this.plusOderMinus = plusOderMinus;
    }

    public char getPlusOderMinus() {
        return plusOderMinus;
    }

    @Override
    public String toString() {
        return "DVD Titel : " + getTitel() + ", Preis : " + getPreis() + ", Speichergroesse : " + getMegaByteGroesse()
                + ", Plus oder Minus : " + getPlusOderMinus();
    }
}
