package Aufgabenblatt1;

/**
 * Eine Klasse für die static Methode.
 * 
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 */
public class Main {

	/**
	 * 
	 * Prüft,ob das erste Element eine Zahl ist
	 * 
	 * @return boolean
	 * 		 Ist das erste Element eine Zahl TRUE,
	 * ansonsten FALSE wenn nicht
	 */
	 public static boolean obErstesElementZahl(ArrayListe<?> list) {
		if (list.get(0) instanceof Number) {
			return true;
		}
		return false;
	}

}