package Generics.Bottle;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class RedWine extends Wine{
    public RedWine(String region) {
        super(region);
    }

    public String toString() {
        return "Bottle{content=RedWine{region=" + getRegion()+"}}";
    }
}
