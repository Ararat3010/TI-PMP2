package Aufgabenblatt2;

/**
 * Diese Klasse Simuliert ein Rennauto
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * @autho Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 */
public class Rennauto extends Thread implements Comparable<Rennauto> {
	/**
	 * Variable Geschwindigkeit der Autos 0,8-1,2
	 */
	private double geschwindigkeit;
	
	/**
	 * Streckenlänge des Rennens
	 */
	private double streckenlaenge;

	/**
	 * Konstruktor des Autos
	 * @param speed
	 * @param length
	 */
	public Rennauto(double speed, double length) {
		this.geschwindigkeit = speed;
		this.streckenlaenge = length;
	}

	/**
	 * Variable zum Speichern der benötigten Zeit für ein Rennen
	 */
	private double gesamteRennzeit = 0.0;

	/**
	 * Getter für die Zeit
	 * @return
	 */
	public double getZeit() {
		return this.gesamteRennzeit;
	}

	/**
	 * run-Methode der Klasse Rennauto,in jedem Schritt wird die Geschwindigkeit verändert. 
	 * Sie variiert zufallsbasiert von 0,8 sek. - 1,2 sek.
	 * Nach jedem Schritt wird die Postion des Autos auf der Strecke ausgegeben.
	 * Wenn das Auto das Ziel erreicht, erfolgt eine Ausgabe("Auto hat das Ziel erreicht").
	 * Wenn ein Rennabbruch das Rennen beendet, wird das Rennen abgebrochen und die Autos 
	 * kommen nicht ins Ziel.
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			for (double schritte = 1; schritte <= this.streckenlaenge & !isInterrupted(); schritte++) {
				geschwindigkeit = (Math.random() * 0.4 + 0.8);
				gesamteRennzeit += geschwindigkeit;
				geschwindigkeit *= 1000;
				System.err.format(Thread.currentThread().getName() + ": %.1f/%.1f\n", schritte, this.streckenlaenge);
				if (schritte == this.streckenlaenge) {
					System.err.format("%s hat das Ziel erreicht\n", this.getName());
					interrupt();
				}
				try {
					Thread.sleep((long) geschwindigkeit);
				} catch (InterruptedException e) {
					interrupt();
				}
			}
		}
	}

	/**
	 * Sortieren der Autos nach Zeit
	 * 
	 * @param auto
	 * @return
	 */
	@Override
	public int compareTo(Rennauto auto) {
		int ergebnis = 0;
		if (getZeit() < auto.getZeit()) {
			ergebnis = -1;
		}
		if (getZeit() == auto.getZeit()) {
			ergebnis = 0;
		}
		if (getZeit() > auto.getZeit()) {
			ergebnis = 1;
		}
		return ergebnis;
	}

}
