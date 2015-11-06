package Aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

import Aufgabenblatt2.Rechner.Operation;

/** Testklasse für Rechner
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 */
 

public class RechnerTest {

	private static final double DELTA = 1E-14;

	@Test
	public void testRechner() {
		Rechner test = new Rechner();
		// Addition testen
		assertEquals(test.berechne(Operation.ADDITION, 25, 25), 50, DELTA);
		// Subtraktion testen
		assertEquals(test.berechne(Operation.SUBTRAKTION, 50, 25), 25, DELTA);
		// Multiplikation testen
		assertEquals(test.berechne(Operation.MULTIPLIKATION, 30, 50), 1500,
				DELTA);
		// Division testen
		assertEquals(test.berechne(Operation.DIVISION, 1500, 30), 50, DELTA);

	}

}
