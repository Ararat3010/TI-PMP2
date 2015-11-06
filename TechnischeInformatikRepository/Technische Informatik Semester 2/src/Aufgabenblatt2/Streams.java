package Aufgabenblatt2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Eine Klasse die mit Streams arbeitet 
 * 
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 * 			Aufgabe: Aufgabenblatt 2, Aufgabe 2			
 */

public class Streams {

	String[] listArray = { "Eingabe", "Aüßeres", null, "Strassen-Feger",
			"ein Haus" };
	List<String> list = Arrays.asList(listArray);
	List<String> listStream = list.stream()
			.filter(s -> s != null)
			.map(s -> s.trim())
			.map(s -> s.toUpperCase())
			.map(s -> s.replaceAll("Ä", "AE"))
			.map(s -> s.replaceAll("Ö", "OE"))
			.map(s -> s.replaceAll("Ü", "UE"))
			.map(s -> s.replaceAll("ß", "SS"))
			.map(s->{
				if(s.length() > 8){
				return s.substring(0, 8);
				}
				return s;
				
			})
			.collect(Collectors.toList());

}
