package Aufgabenblatt3;

/**
 * 
 * Mit dieser Klasse werden die Zuege ausgefahren.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 3, Aufgabe 2
 */

public class AufgabeZugAusfahren implements Aufgaben {

	/**
	 * Bahnhofsvariable
	 */
	Rangierbahnhof bahnhof;

	private int zufallsgleis;
	
	/**
	 * Konstruktor
	 */
	public AufgabeZugAusfahren(Rangierbahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	/**
	 * implementierte Methode aus dem Interface "Aufgaben"
	 */
	@Override
	public void aufgabe() {
		zufallsgleis = (int) (Math.random() * 3);
		if(bahnhof.getGleise(zufallsgleis)!=null){
		bahnhof.zugAusfahren(zufallsgleis);
		}
	}

	@Override
	public String toString() {
		return "";
	}

}
