package Aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Aufgabenblatt2.Rechner.Operation;

/**
 * Testklasse für Rechner
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 1
 *
 */

public class RechnerTest {

	/**
	 * Für die Nullstellen
	 */
	private static final double DELTA = 1E-14;

	@Test
	public void testRechner() throws Exception {
		Rechner test = new Rechner();
		// Addition testen
		assertEquals(test.berechne(Operation.ADDITION, 25, 25), 50, DELTA);
		assertEquals(test.berechne(Operation.ADDITION, 25, -25), 0, DELTA);
		assertEquals(test.berechne(Operation.ADDITION, -25, -30), -55, DELTA);
		// Subtraktion testen
		assertEquals(test.berechne(Operation.SUBTRAKTION, 50, 25), 25, DELTA);
		assertEquals(test.berechne(Operation.SUBTRAKTION, 50, -25), 75, DELTA);
		assertEquals(test.berechne(Operation.SUBTRAKTION, -50, -25), -25, DELTA);
		// Multiplikation testen
		assertEquals(test.berechne(Operation.MULTIPLIKATION, 30, 50), 1500,DELTA);
		assertEquals(test.berechne(Operation.MULTIPLIKATION, 30, -50), -1500,DELTA);
		assertEquals(test.berechne(Operation.MULTIPLIKATION, -30, -50), 1500,DELTA);
		// Division testen
		assertEquals(test.berechne(Operation.DIVISION, 1500, 30), 50, DELTA);
		assertEquals(test.berechne(Operation.DIVISION, 1500, -30), -50, DELTA);
		assertEquals(test.berechne(Operation.DIVISION, -1500, -30), 50, DELTA);

		// Wenn der Operator null ist

		try {
			assertEquals(test.berechne(null, -25, -30), -55, DELTA);
			Assert.assertTrue("Fehler: Der Operator darf nicht null sein", false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// Division durch 0

		try {
			assertEquals(test.berechne(Operation.DIVISION, 1500, 0), 50, DELTA);
			Assert.assertTrue("Fehler: Darf nicht durch 0 geteilt werden",
					false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Addition,Division,Multiplikation und Subtraktion mit null
		extracted(test);
	}

	
	@SuppressWarnings({ "deprecation", "null" })
	private void extracted(Rechner test) throws Exception {
		try {
			assertEquals(test.berechne(Operation.ADDITION, 20, (Double) null), DELTA);
			assertEquals(test.berechne(Operation.ADDITION, (Double) null, 20), DELTA);
			assertEquals(test.berechne(Operation.DIVISION, 30, (Double) null), DELTA);
			assertEquals(test.berechne(Operation.DIVISION, (Double) null, 10), DELTA);
			assertEquals(test.berechne(Operation.MULTIPLIKATION, 50, (Double) null), DELTA);
			assertEquals(test.berechne(Operation.MULTIPLIKATION, (Double) null, 50), DELTA);
			assertEquals(test.berechne(Operation.SUBTRAKTION, (Double) null, 40), DELTA);
			assertEquals(test.berechne(Operation.SUBTRAKTION, 10, (Double) null), DELTA);
			Assert.assertTrue("NullPointerException", false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
