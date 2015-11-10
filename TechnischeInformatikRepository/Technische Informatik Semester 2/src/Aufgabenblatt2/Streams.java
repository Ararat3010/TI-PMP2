package Aufgabenblatt2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Eine Klasse die mit Streams arbeitet
 * 
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 2
 */

public class Streams {

	/** 
	 * Version 2.0 läuft nicht 
	 * 
	 * Könntest du dir mal anschauen Bennet woran das liegt, dass 
	 * die Test fehlschlagen obwohl alles stimmt "was er erwartet und erhält 
	 * ist indentisch....
	 * 
	 * 
	 * @param text
	 * @return
	 */
	
	
	public List<String> verarbeitungVonStrings(String text){
		
		String[] listArray = {text};
		List<String> list = Arrays.asList(listArray);
		List<String> listStream = list.stream().filter(s -> s != null)
									.map(s -> s.trim()).map(s -> s.toUpperCase())
									.map(s->s.replaceAll("Ä", "AE")
											 .replaceAll("Ö", "OE")
											 .replaceAll("Ü", "UE")
										 	 .replaceAll("ß", "SS"))
									.map(s -> {
										if (s.length() > 8) {
											return s.substring(0, 8);
										}
										return s;

									}).collect(Collectors.toList());
		return listStream;
											
		
		
	}
	
	/** 
	 * Aktuelle Version 1.0 die läuft ohne Methode
	 */
	
	
	String[] listArray = { "Eingabe", "Aüßeres", null, "Strassen-Feger",
							"ein Haus" };
	List<String> list = Arrays.asList(listArray);
	List<String> listStream = list.stream().filter(s -> s != null)
								.map(s -> s.trim()).map(s -> s.toUpperCase())
								.map(s->s.replaceAll("Ä", "AE")
										 .replaceAll("Ö", "OE")
										 .replaceAll("Ü", "UE")
									 	 .replaceAll("ß", "SS"))
								.map(s -> {
									if (s.length() > 8) {
										return s.substring(0, 8);
									}
									return s;

								}).collect(Collectors.toList());

}
