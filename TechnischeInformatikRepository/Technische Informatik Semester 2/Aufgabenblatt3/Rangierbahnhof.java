package Aufgabenblatt3;

/**
 * 
 * Eine Klasse die ein Rangierbahnhof darstellt.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 3, Aufgabe 1
 */

public class Rangierbahnhof {

	/**
	 * Array fuer die Gleise
	 */
	private Zug[] gleise;

	/**
	 * Konstruktor
	 * 
	 * @param anzahl
	 */
	public Rangierbahnhof(int anzahl) {
		this.gleise = new Zug[anzahl];
	}

	/**
	 * Diese Methode ist zum einfahren eines Zuges auf den Rangierbahnhof
	 * 
	 * @param zug
	 * @param gleis
	 */
	public synchronized void zugEinfahren(Zug zug, int gleis) {
		while (this.gleise[gleis] == null) {
			try {
				if (this.gleise[gleis] == null) {
					this.gleise[gleis] = zug;
					notify();
					break;
				}
				wait();
			} catch (InterruptedException e) {

			}

		}
	}

	/**
	 * Diese Methode ist zum ausfahren eines Zuges aus dem Rangierbahnhof
	 * 
	 * @param gleis
	 */
	public synchronized void zugAusfahren(int gleis) {
		while (this.gleise[gleis] != null) {
			try {
				if (this.gleise[gleis] != null) {
					this.gleise[gleis] = null;
					notify();
					break;
				}
				wait();
			} catch (InterruptedException e) {

			}
		}
	}
}