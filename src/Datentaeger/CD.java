package Datentaeger;

/**
 * Created: 15.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class CD extends Datentraeger{
    private boolean readOnly;

    public CD() {
        super();
    }

    public CD(String titel, double preis, boolean readOnly) {
        super(titel, preis);
        this.readOnly = readOnly;
    }

    public CD(String titel, double preis, int megaByteGroesse, boolean readOnly) {
        super(titel, preis, megaByteGroesse);
        this.readOnly = readOnly;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public String toString() {
        return "CD Titel : " + getTitel() + ", Preis : " + getPreis() + ", Speichergroesse : " + getMegaByteGroesse()
                + ", Readonly : " + isReadOnly();
    }
}
