package Aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleDoubleZuDoubleTest {

	private final double DELTA = 1E-14;

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