package Aufgabenblatt2;


/**
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
	private Rennauto auto1;
	
	/**
	 * Zweites Auto
	 */
	private Rennauto auto2;
	
	/**
	 * Drittes Auto
	 */
	private Rennauto auto3;
	
	/**
	 * Viertes Auto
	 */
	private Rennauto auto4;
	
	/**
	 * Variable fuer die Rundenanzahl
	 */
	private int runden;

	/**
	 * Konstruktor fuer die Autos
	 * @param auto1
	 * @param auto2
	 * @param auto3
	 * @param auto4
	 */
	public Rennabbruch(Rennauto auto1, Rennauto auto2, Rennauto auto3,
			Rennauto auto4,int runden) {
		this.auto1 = auto1;
		this.auto2 = auto2;
		this.auto3 = auto3;
		this.auto4 = auto4;
		this.runden = runden;
		
	}

	/**
	 * Die Funktion Math.random errechnet eine Zufallszahl in dem Bereich 1-10
	 * (rennAbbruchWahrscheinlichkeit).
	 * Nach jeder Berechnung wird eine Sekunde gewartet
	 * Wenn die Wahrscheinlichkeit 1 ist (10%), dann werden alle Rennauto-Threads beendet.
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			for (int i = 1; !isInterrupted(); i++) {
				int rennabbruchWahrscheinlichkeit = (int) (Math.random() *9+1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					interrupt();
				}
				if (rennabbruchWahrscheinlichkeit == 1) {
					interrupt();
					auto1.interrupt();
					auto2.interrupt();
					auto3.interrupt();
					auto4.interrupt();
					System.out.println("Rennabbruch\n");
				}
				if (i == this.runden)
					interrupt();
			}
		}
	}
}
