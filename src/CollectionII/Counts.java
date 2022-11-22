package CollectionII;

/**
 * Created: 03.11.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class Counts {
    private String str;
    private int differentChars;

    public Counts(String str, int differentChars) {
        this.str = str;
        this.differentChars = differentChars;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getDifferentChars() {
        return differentChars;
    }

    public void setDifferentChars(int differentChars) {
        this.differentChars = differentChars;
    }

    @Override
    public String toString() {
        return getStr()+ " : " + getDifferentChars();
    }
}
