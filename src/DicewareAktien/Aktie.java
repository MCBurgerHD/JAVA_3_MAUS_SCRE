package DicewareAktien;

/**
 * Created: 26.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Aktie {
    String name;
    int rating;
    int preis;

    int shares;

    public Aktie() {
        this("",0,0, 0);
    }

    public Aktie(String name, int rating, int preis) {
        this(name, rating, preis,0);
    }

    public Aktie(String name, int rating, int preis, int shares) {
        this.name = name;
        this.rating = rating;
        this.preis = preis;
        this.shares = shares;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }
}
