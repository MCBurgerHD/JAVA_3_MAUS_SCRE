package Generics.Bottle;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Beer extends Drink{

    private String brewery;

    public Beer(String brewery) {
        this.brewery = brewery;
    }

    public String getBrewery() {
        return brewery;
    }

    @Override
    public String toString() {
        return "Bottle{content=Beer{brewery=" + getBrewery()+"}}";
    }
}
