package Datentaeger;

/**
 * Created: 15.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */

public class WertNegativException extends RuntimeException{

    public WertNegativException() {
    }

    public WertNegativException(String str) {
        super(str);
    }
}
