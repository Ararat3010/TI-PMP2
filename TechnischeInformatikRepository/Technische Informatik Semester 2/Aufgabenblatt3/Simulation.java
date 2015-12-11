package Aufgabenblatt3;

import java.util.Observable;

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

public class Simulation extends Observable implements Runnable {

	/**
	 * Erstellen eines Bahnhofs-Objekt's
	 */
	private Rangierbahnhof bahnhof;

	public Simulation(Rangierbahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	public Rangierbahnhof getBahnhof() {
		return bahnhof;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Lokfuehrer lok1 = new Lokfuehrer(new AufgabeZugEinfahren(
						this.bahnhof, new Zug()));
				lok1.start();
				Thread.sleep(500);
				System.out.println(lok1);
				
				Lokfuehrer lok2 = new Lokfuehrer(new AufgabeZugAusfahren(
						this.bahnhof));
				lok2.start();
				Thread.sleep(500);
				System.out.println(lok2);
			} catch (InterruptedException e) {

			}
		
			setChanged();
			notifyObservers();
			
		}
	}
	
}
