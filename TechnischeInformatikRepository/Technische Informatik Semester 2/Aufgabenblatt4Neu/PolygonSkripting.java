package Aufgabenblatt4Neu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Die Klasse prüft Befehle auf ihre Richtigkeit
 * 
 *
 */
public class PolygonSkripting {

	/**
	 * Variable Pattern
	 */
	private final Pattern pattern;
	/**
	 * Variable Matcher
	 */
	private Matcher matcher;

	/**
	 * Konstruktor
	 */
	public PolygonSkripting() {
		pattern = Pattern.compile("(bewege) -> (\\d{1}\\d?\\d?),(\\d{1}\\d?\\d?)");
		matcher = null;
	}

	/**
	 * Die Methode prüft einen Befehl auf seine Richtigkeit
	 * 
	 * @param befehl
	 * 
	 * @return Richtigkeit des Befehls als Boolean
	 */
	public boolean pruefeBefehl(String befehl) {
		matcher = pattern.matcher(befehl);
		return matcher.matches();
	}

	/**
	 * Die Methode gibt die x-Koordinate wieder. Bei einem Falschen Befehl gibt
	 * es eine Exception
	 * 
	 * @param befehl
	 * @return x-Koordinate
	 * @throws Exception
	 */
	public double getX(String befehl) throws Exception {
		if (pruefeBefehl(befehl)) {
			return new Double(matcher.group(2));
		} else {
			throw new Exception();
		}
	}

	/**
	 * Die Methode gibt die y-Koordinate wieder. Bei einem Falschen Befehl gibt
	 * es eine Exception
	 * 
	 * @param befehl
	 * @return y-Koordinate
	 * @throws Exception
	 */
	public double getY(String befehl) throws Exception {
		if (pruefeBefehl(befehl)) {
			return new Double(matcher.group(3));
		} else {
			throw new Exception("Kein gueltiger Befehl!");
		}
	}

}
