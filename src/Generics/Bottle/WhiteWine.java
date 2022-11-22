package Generics.Bottle;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class WhiteWine extends Wine{
    public WhiteWine(String region) {
        super(region);
    }

    public String toString() {
        return "Bottle{content=WhiteWine{region=" + getRegion()+"}}";
    }
}
