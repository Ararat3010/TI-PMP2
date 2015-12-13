package Aufgabenblatt3;

/**
 * 
 * In dieser Klasse Lokfuehrer, bekommen die Lokfuehrer verschidene Aufgaben
 * zugeteilt.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 3, Aufgabe 2
 */

public class Lokfuehrer extends Thread {

	/**
	 * Aufgabe des Lokfuehrers, entweder Einfahren oder Ausfahren
	 */
	private Aufgaben aufgabe;

	/**
	 * Konstruktor fuer den Lokfuehrer
	 * 
	 * @param aufgabe
	 */
	public Lokfuehrer(Aufgaben aufgabe) {
		this.aufgabe = aufgabe;
	}

	/**
	 * run()-Methode des Lokfuehrers, entweder Ein- oder Ausfahren eines Zuges
	 */
	@Override
	public void run() {
		aufgabe.aufgabe();
	}

	@Override
	public String toString() {
		return "";
	}
}
