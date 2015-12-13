package Aufgabenblatt3;

/**
 * 
 * Mit dieser Klasse werden die Zuege eingefahren.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 3, Aufgabe 2
 */

public class AufgabeZugEinfahren implements Aufgaben {

	/**
	 * Bahnhofsvariable
	 */
	private Rangierbahnhof bahnhof;

	private int zufallsgleis;
	
	/**
	 * Zugvariable
	 */
	private Zug zug;

	/**
	 * Konstruktor
	 */
	public AufgabeZugEinfahren(Rangierbahnhof bahnhof, Zug zug) {
		this.bahnhof = bahnhof;
		this.zug = zug;

	}

	/**
	 * implementierte Methode aus dem Interface "Aufgaben"
	 */
	@Override
	public void aufgabe() {
		zufallsgleis = (int) (Math.random() * 3);
		if(bahnhof.getGleise(zufallsgleis)==null){
		bahnhof.zugEinfahren(zug, zufallsgleis);
		} 

	}

	@Override
	public String toString() {
		return "";
	}

}
