package Flugzeug;

/**
 * Created: 08.09.2022
 *
 * @author Maximilian Ertl (Maximilian Ertl)
 */

public class Militaerflugzeug extends Flugzeug{
    private boolean stealthTechnik;

    public Militaerflugzeug(){}

    public Militaerflugzeug(String bezeichnung, double preis, int triebwerkanzahl, boolean stealthTechnik) {
        super(bezeichnung, preis, triebwerkanzahl);
        this.stealthTechnik = stealthTechnik;
    }

    public boolean getStealthTechnik() {
        return stealthTechnik;
    }

    public void setStealthTechnik(boolean stealthTechnik) {
        this.stealthTechnik = stealthTechnik;
    }
}
