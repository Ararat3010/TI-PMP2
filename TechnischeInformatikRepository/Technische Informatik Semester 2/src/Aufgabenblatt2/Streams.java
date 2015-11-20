package Aufgabenblatt2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Eine Klasse die mit Streams arbeitet
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 2
 */

public class Streams {

	/**
	 * Methode zu verarbeitung von Strings
	 *
	 * @param text
	 * @return
	 */

	public List<String> verarbeitungVonStrings(String text) {
		String[] listArray = { text };
		List<String> list = Arrays.asList(listArray);
		List<String> listStream = list
				.stream()
				.filter(s -> s != null)
				.map(s -> s.trim())
				.map(s -> s.toUpperCase())
				.map(s -> s.replaceAll("Ä", "AE").replaceAll("Ö", "OE")
						.replaceAll("Ü", "UE").replaceAll("ß", "SS"))
				.map(s -> {
					if (s.length() > 8) {
						return s.substring(0, 8);
					}
					return s;

				}).collect(Collectors.toList());

		return listStream;
	
	}

}
