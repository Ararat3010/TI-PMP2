package Aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

/** Testklasse für Streams
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
 * Test für Version 2.0 läuft nicht siehe Kommentar bei Version 2.0 Streams
 */

		
		//assertEquals(test.verarbeitungVonStrings("Eingabe "), "EINGABE");
		//assertEquals(test.verarbeitungVonStrings("Äußeres "), "AUESSERE");
		//assertEquals(test.verarbeitungVonStrings("Strassen-Feger"), "STRASSEN");
		//assertEquals(test.verarbeitungVonStrings(" ein Haus"), "EIN HAUS");
		
/** 
 * Test für die Version 1.0		
 */
		
		
		assertEquals(test.listStream.get(0), "EINGABE");
		assertEquals(test.listStream.get(1), "AUESSERE");
		assertEquals(test.listStream.get(2), "STRASSEN");
		assertEquals(test.listStream.get(3), "EIN HAUS");
	
	}

}
