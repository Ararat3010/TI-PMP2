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
		
		Streams testListe = new Streams();

		String[] listArray = {"Eingabe ","Äußeres ",null,"Strassen-Feger"," ein Haus"};
		 
		String[] listArrayKorrekt = {"EINGABE","AEUSSERE","STRASSEN","EIN HAUS"};
		List<String> listeKorrekt = Arrays.asList(listArrayKorrekt);
		
		assertEquals(testListe.verarbeitungVonStrings(listArray),listeKorrekt);
		
		
	}

}
