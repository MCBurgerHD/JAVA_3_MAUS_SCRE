package Generics.Bottle;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public abstract class Wine extends Drink{

    private String region;

    public Wine(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Bottle{content=Wine{region=" + getRegion() +"}}";
    }
}
