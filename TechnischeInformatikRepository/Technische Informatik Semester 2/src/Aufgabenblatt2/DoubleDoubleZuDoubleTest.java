package Aufgabenblatt2;

import static org.junit.Assert.*;
import org.junit.Test;
/**
* Praktikum TIPR2, WS 2015
*
* @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
* @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
* 
*         Aufgabe: Aufgabenblatt 2, Aufgabe 1
*/
public class DoubleDoubleZuDoubleTest {
	
	/**
	 *  Für die Nullstellen
	 */
	private static final double DELTA = 1E-14;

	/** Multiplikation testen */

	@Test
	public void testMultiplikationFunctionalInterface() {
		DoubleDoubleZuDouble functionalInterface;
		functionalInterface = (x, y) -> x * y;
		assertEquals(functionalInterface.werteAus(150, 250), 37500, DELTA);
	}

	/** Division testen */

	@Test
	public void testDivisionFunctionalInterface() {
		DoubleDoubleZuDouble functionalInterface;
		functionalInterface = (x, y) -> x / y;
		assertEquals(functionalInterface.werteAus(100, 2), 50, DELTA);
	}

	/** Addition testen */

	@Test
	public void testAdditionFunctionalInterface() {
		DoubleDoubleZuDouble functionalInterface;
		functionalInterface = (x, y) -> x + y;
		assertEquals(functionalInterface.werteAus(1750, 1250), 3000, DELTA);
	}

	/** Subtraktion testen */

	@Test
	public void testSubtraktionFunctionalInterface() {
		DoubleDoubleZuDouble functionalInterface;
		functionalInterface = (x, y) -> x - y;
		assertEquals(functionalInterface.werteAus(3000, 1250), 1750, DELTA);
	}

	/** Nullstellen berechnen */

	@Test
	public void testNullstenBerechnenFunctionalInterface() {
		DoubleDoubleZuDouble functionalInterface;
		functionalInterface = (a, b) -> (-a) / b;
		assertEquals(functionalInterface.werteAus(-2, 5), 0.4, DELTA);
	}

}