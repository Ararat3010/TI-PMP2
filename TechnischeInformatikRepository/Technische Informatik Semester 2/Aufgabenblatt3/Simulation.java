package Aufgabenblatt3;

import java.util.Observable;

/**
 * 
 * Die Klasse Simulation repraesentiert ein Programm, in dem Lokfuehrer erstellt
 * werden, welche die Zuege Ein-und Ausfahren.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 3, Aufgabe 3
 */

public class Simulation extends Observable implements Runnable {

	/**
	 * Erstellen eines Bahnhofs-Objekt's
	 */
	private Rangierbahnhof bahnhof;

	/**
	 * Konstruktor fuer den Bahnhof
	 * 
	 * @param bahnhof
	 */
	public Simulation(Rangierbahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	/**
	 * Getter fuer die Bahnhofsvariable
	 * 
	 * @return
	 */
	public Rangierbahnhof getBahnhof() {
		return bahnhof;
	}

	/**
	 * In dieser Run-Methode wird alle 500ms ein neuer Lokfuehrer-Thread
	 * erstellt. Die jeweilige Aufgabe des Lokfuehrers wird zufallsbasiert
	 * ausgewaehlt. Entweder wird ein Zug aus einem Gleis Ein- oder Ausgefahren.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				int randomAufgabe = (int) (Math.random() * 2);
				if (randomAufgabe == 0) {
					Lokfuehrer lok1 = new Lokfuehrer(new AufgabeZugEinfahren(this.bahnhof, new Zug()));
					lok1.start();
					Thread.sleep(500);
				} else {
					Lokfuehrer lok2 = new Lokfuehrer(new AufgabeZugAusfahren(this.bahnhof));
					lok2.start();
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {

			}
			setChanged();
			notifyObservers();
		}
	}

}
