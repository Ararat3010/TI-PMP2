package Aufgabenblatt2;


/** Ein Funktionales Interface für "DoubleDoubleZuDouble" 
 * die eine Methode werteAus() besitzt 
 * 
 * 
 *  * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 1
 */


@FunctionalInterface
public interface DoubleDoubleZuDouble {
	public double werteAus(double wert1, double wert2);
}
