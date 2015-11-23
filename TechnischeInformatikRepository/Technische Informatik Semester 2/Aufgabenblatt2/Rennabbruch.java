package Aufgabenblatt2;

import java.util.List;

/**
 * 
 * Diese Klasse Simuliert einen Rennabbruch
 * 
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * @autho Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 */
public class Rennabbruch extends Thread {
	/**
	 * Erstes Auto
	 */
	private List<Rennauto> autoliste;

	/**
	 * Variable fuer die Rundenanzahl
	 */
	private int runden;

	/**
	 * Konstruktor fuer die Autos
	 * 
	 * @param auto1
	 * @param auto2
	 * @param auto3
	 * @param auto4
	 */
	public Rennabbruch(List<Rennauto> autoliste, int runden) {
		this.autoliste = autoliste;
		this.runden = runden;

	}

	/**
	 * Die Funktion Math.random errechnet eine Zufallszahl in dem Bereich 1-10
	 * (rennAbbruchWahrscheinlichkeit). Nach jeder Berechnung wird eine Sekunde
	 * gewartet Wenn die Wahrscheinlichkeit 1 ist (10%), dann werden alle
	 * Rennauto-Threads beendet.
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			for (int i = 1; !isInterrupted(); i++) {
				int rennabbruchWahrscheinlichkeit = (int) (Math.random() * 9 + 1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					interrupt();
				}
				if (rennabbruchWahrscheinlichkeit == 1) {
					interrupt();
					for (Rennauto rennauto : autoliste) {
						rennauto.interrupt();
					}
					System.out.println("Rennabbruch\n");
				}
				if (i == this.runden)
					interrupt();
			}
		}
	}
}
