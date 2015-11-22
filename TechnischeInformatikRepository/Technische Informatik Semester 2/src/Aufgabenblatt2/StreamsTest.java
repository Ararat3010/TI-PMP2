package Aufgabenblatt2;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * Testklasse fuer Streams
 * 
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 2
 *
 */

public class StreamsTest {

	@Test
	public void testStreams() {
		
		Streams test = new Streams();

//		List<String> eingabe = new LinkedList<String>();
//		eingabe.add("EINGABE");
//		List<String> aeussere = new LinkedList<String>();
//		aeussere.add("AEUSSERE");
//		List<String> nulltest = new LinkedList<String>();
//		List<String> strassen = new LinkedList<String>();
//		strassen.add("STRASSEN");
//		List<String> einHaus = new LinkedList<String>();
//		einHaus.add("EIN HAUS");
//		assertEquals(test.verarbeitungVonStrings("Eingabe "), eingabe);
//		assertEquals(test.verarbeitungVonStrings("√Ñu√üere "), aeussere);
//		assertEquals(test.verarbeitungVonStrings(null), nulltest);
//		assertEquals(test.verarbeitungVonStrings("Strassen-Feger"), strassen);
//		assertEquals(test.verarbeitungVonStrings(" ein Haus"), einHaus);

		/**
		 * ‹berarbeitung 21.November 15
		 */
		String[] listArray = {"Eingabe ","Äußeres ",null,"Strassen-Feger"," ein Haus"};
		 
		String[] listArrayKorrekt = {"EINGABE","AEUSSERE","STRASSEN","EIN HAUS"};
		List<String> list2 = Arrays.asList(listArrayKorrekt);
		
		assertEquals(test.verarbeitungVonStrings(listArray),list2);
		
		
	}

}
