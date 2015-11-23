package Aufgabenblatt2;

/**
 * 
 * Diese Klasse Simuliert ein Rennauto
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 3
 */
public class Rennauto extends Thread implements Comparable<Rennauto> {

	/**
	 * Variable Geschwindigkeit der Autos 0,8-1,2
	 */
	private double durchschnittsGeschwindigkeit;

	/**
	 * Marke der gesponsorten Autos
	 */
	private String name;

	/**
	 * Streckenlaenge des Rennens
	 */
	private double laengeDerRennstrecke;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param durchschnittsGeschwindigkeit
	 * @param laengeDerRennstrecke
	 */
	public Rennauto(String name, double durchschnittsGeschwindigkeit, double laengeDerRennstrecke) {
		this.name = name;
		this.durchschnittsGeschwindigkeit = durchschnittsGeschwindigkeit;
		this.laengeDerRennstrecke = laengeDerRennstrecke;

	}

	/**
	 * Variable zum Speichern der benoetigten Zeit fuer ein Rennen
	 */
	private double gesamteRennzeit = 0.0;

	/**
	 * run-Methode der Klasse Rennauto,in jedem Schritt wird die Geschwindigkeit
	 * veraendert. Sie variiert zufallsbasiert von 0,8 sek. - 1,2 sek. Nach
	 * jedem Schritt wird die Postion des Autos auf der Strecke ausgegeben. Wenn
	 * das Auto das Ziel erreicht, erfolgt eine Ausgabe(
	 * "Auto hat das Ziel erreicht"). Wenn ein Rennabbruch das Rennen beendet,
	 * wird das Rennen abgebrochen und die Autos kommen nicht ins Ziel.
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			for (double schritte = 1; schritte <= this.laengeDerRennstrecke && !isInterrupted(); schritte++) {
				durchschnittsGeschwindigkeit = (Math.random() * 0.4 + 0.8);
				gesamteRennzeit += durchschnittsGeschwindigkeit;
				durchschnittsGeschwindigkeit *= 1000;
				gesamteRennzeit = Math.round(100.0 * gesamteRennzeit) / 100.0;
				System.err.format(Thread.currentThread().getName() + getSponsor() + name + ": %.1f/%.1f\n", schritte,
						this.laengeDerRennstrecke);
				if (schritte == this.laengeDerRennstrecke) {
					System.err.format("%s hat das Ziel erreicht\n", this.getName());
					interrupt();
				}
				try {
					Thread.sleep((long) durchschnittsGeschwindigkeit);
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
		if (this.gesamteRennzeit < auto.gesamteRennzeit) {
			ergebnis = -1;
		}
		if (this.gesamteRennzeit == auto.gesamteRennzeit) {
			ergebnis = 0;
		}
		if (this.gesamteRennzeit > auto.gesamteRennzeit) {
			ergebnis = 1;
		}
		return ergebnis;
	}

	/**
	 * Eigene Hilfsmethode fuer Sponsor
	 * 
	 * @return
	 */
	private String getSponsor() {
		return " sponsored by ";
	}

	/**
	 * toString Methode fuer die Ausgabe
	 */
	public String toString() {
		return getName() + ": " + this.name + ": " + this.gesamteRennzeit + " Sekunden";
	}
}
