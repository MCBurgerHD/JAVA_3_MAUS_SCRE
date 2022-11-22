package Flugzeug;

/**
 * Created: 08.09.2022
 *
 * @author Maximilian Ertl (Maximilian Ertl)
 */

public class Verkehrsflugzeug extends Flugzeug{
    private int passagierAnzahl;

    public Verkehrsflugzeug(){
    }

    public Verkehrsflugzeug(String bezeichnung, double preis, int triebwerkanzahl, int passagierAnzahl) {
        super(bezeichnung, preis, triebwerkanzahl);
        if (passagierAnzahl < 0) {
            throw new WertNegativException("Passagieranzahl NEGATIV!");
        }
        this.passagierAnzahl = passagierAnzahl;
    }

    public int getPassagierAnzahl() {
        return passagierAnzahl;
    }

    public void setPassagierAnzahl(int passagierAnzahl) {
        this.passagierAnzahl = passagierAnzahl;
    }
}
