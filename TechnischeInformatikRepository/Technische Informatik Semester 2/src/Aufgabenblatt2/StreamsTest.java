package Aufgabenblatt2;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/** Testklasse fuer Streams
 * 
 * Aenderung 11.11.2015: 
 * Die Methode verarbeitungVonStrings() wird mit einer Liste, 
 * welche das umgewandelte Wort enth‰lt, verglichen.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 */

public class StreamsTest {

	@Test
	public void testStreams() {
		Streams test = new Streams();
	
/**
 * Test f√ºr Version 2.0 
 */
		//Aenderung 11.11.15
		List<String> eingabe = new LinkedList();
		eingabe.add("EINGABE");
		List<String> aeussere = new LinkedList();
		aeussere.add("AEUSSERE");
		List<String> strassen = new LinkedList();
		strassen.add("STRASSEN");
		List<String> einHaus = new LinkedList();
		einHaus.add("EIN HAUS");
		assertEquals(test.verarbeitungVonStrings("Eingabe "), eingabe);
		assertEquals(test.verarbeitungVonStrings("ƒuﬂere "), aeussere);
		assertEquals(test.verarbeitungVonStrings("Strassen-Feger"), strassen);
		assertEquals(test.verarbeitungVonStrings(" ein Haus"), einHaus);
		
/** 
 * Test f√ºr die Version 1.0		
 */
		
		
		assertEquals(test.listStream.get(0), "EINGABE");
		assertEquals(test.listStream.get(1), "AUESSERE");
		assertEquals(test.listStream.get(2), "STRASSEN");
		assertEquals(test.listStream.get(3), "EIN HAUS");
	
	}

}
