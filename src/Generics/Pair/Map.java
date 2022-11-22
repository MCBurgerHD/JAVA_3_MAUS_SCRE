package Generics.Pair;

/**
 * Created: 29.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public interface Map <K, V> {
    /**
     * Fügt ein neues Key - Value - Paar dieser Map hinzu .
     * Sollte der Key schon existieren , wird der Value ersetzt
     * und der alte Value wird retourniert .
     * Ein key null wird mit einer IllegalArgumentException
     abgelehnt .
     *
     * @return den alten Value bzw null , wenn der Key neu ist
     */
    V put(K key, V value );
    /**
     * Liefert den zum Key gehörigen Value bzw null ,
     * wenn der Key nicht existiert .
     *
     * @return den zum Key gehörigen Value bzw null
     */
    V get(K key);
    /**
     * Liefert die Anzahl der Key - Value - Paare in dieser Map.
     *
     * @return Anzahl der Einträge in dieser Map
     */
    int size ();
}
