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
	 * Getter fuer die Gleise
	 * @param index
	 * @return
	 */
	public Zug getGleise(int index) {
		return gleise[index];
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
					System.err.format( "Der Zug wurde auf Gleis %d eingefahren\n",gleis);

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
					System.err.format( "Der Zug wurde auf Gleis %d ausgefahren\n",gleis);

					notify();
					break;
				}
				wait();
			} catch (InterruptedException e) {

			}
		}
	}
}