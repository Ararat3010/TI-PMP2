package Aufgabenblatt3;

/**
 * 
 * Die Klasse Simulation repaesentiert ein Programm, in dem Lokfuhrer erstellt
 * werden, welche die Zuege Ein-und Ausfahren.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 3, Aufgabe 3
 */

public class Simulation implements Runnable {

	/**
	 * Erstellen eines Bahnhofs-Objekt's
	 */
	Rangierbahnhof bahnhof = new Rangierbahnhof(3);

	@Override
	public void run() {
		while (true) {
			try {
				Lokfuehrer lok1 = new Lokfuehrer(new AufgabeZugEinfahren(
						this.bahnhof, new Zug()));
				lok1.start();
				Thread.sleep(500);
				System.out.println(lok1);
			} catch (InterruptedException e) {

			}
			try {
				Lokfuehrer lok2 = new Lokfuehrer(new AufgabeZugAusfahren(
						this.bahnhof));
				lok2.start();
				Thread.sleep(500);
				System.out.println(lok2);
			} catch (InterruptedException e) {

			}
		}
	}

}
