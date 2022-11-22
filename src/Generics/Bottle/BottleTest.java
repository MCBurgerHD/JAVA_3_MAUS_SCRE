package Generics.Bottle;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class BottleTest {
    public static void main(String[] args) {
        Bottle<Beer> beer = new Bottle<>();
        beer.fill(new Beer("Zwettler"));
        System.out.println(beer.toString());
        Beer ret = beer.empty();
        System.out.println(beer.toString());
        Bottle<Wine> wine = new Bottle<>();
        wine.fill((new WhiteWine("Kamptal")));
        System.out.println(wine.toString());
        wine.empty();
        System.out.println(wine.toString());
        wine.fill(new RedWine("Carnuntum"));
        System.out.println(wine.toString());
    }
}
