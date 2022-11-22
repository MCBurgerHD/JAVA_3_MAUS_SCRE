package Flugzeug;

/**
 * Created: 08.09.2022
 *
 * @author Maximilian Ertl (Maximilian Ertl)
 */

public class WertNegativException extends RuntimeException{

    public WertNegativException() {
    }

    public WertNegativException(String str) {
        super(str);
    }
}
