package Aufgabenblatt1;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayListeTest {
	@Test
	public void obErstesElementZahlTest() {
		ArrayListe<Integer> test = new ArrayListe<Integer>();
		test.hinzufuegen(10);
		boolean erstesElement = Main.obErstesElementZahl(test);
		assertEquals(true, erstesElement);
		ArrayListe<String> wortliste = new ArrayListe<String>();
		wortliste.hinzufuegen("Zahl");
		erstesElement = Main.obErstesElementZahl(wortliste);
		assertEquals(false, erstesElement);
	}

	@Test
	public void hinzufuegenTest() {
		ArrayListe<Integer> test = new ArrayListe<Integer>();
		int x = 1;
		int y = 2;
		int z = -5;
		test.hinzufuegen(x);
		test.hinzufuegen(y);
		test.hinzufuegen(z);
		assertEquals("Error!", (int) test.get(0), x);
		assertEquals("Error!", (int) test.get(1), y);
		assertEquals("Error!", (int) test.get(2), z);
	}

	@Test
	public void entfernenEinesObjektsTest() {
		;
		ArrayListe<Integer> list = new ArrayListe<Integer>();
		Integer first = 42;
		list.hinzufuegen(first);
		list.hinzufuegen(21);
		list.entfernen(first);
		assertEquals(21, (int) list.get(0));
		assertEquals(1, list.getAnzahlElemente());
	}

	@Test
	public void entfernenElementAnIndexTest() {
		ArrayListe<Integer> list = new ArrayListe<Integer>();
		list.hinzufuegen(37);
		list.hinzufuegen(14);
		list.entfernenElementeAnIndex(0);
		assertEquals(14, (int) list.get(0));
		assertEquals(1, list.getAnzahlElemente());
		list = new ArrayListe<Integer>();
		list.hinzufuegen(11);
		list.hinzufuegen(21);
		list.hinzufuegen(50);
		list.entfernenElementeAnIndex(2);
		assertEquals(11, (int) list.get(0));
		assertEquals(2, list.getAnzahlElemente());
	}

	@Test
	public void getAnzahlderElementeTest() {
		ArrayListe<Integer> test = new ArrayListe<Integer>();
		test.hinzufuegen(2);
		test.hinzufuegen(158);
		test.hinzufuegen(908);
		assertEquals("Error", test.getAnzahlElemente(), 3);
		ArrayListe<String> test1 = new ArrayListe<String>();
		assertEquals("Error!", test1.getAnzahlElemente(), 0);
	}

	@Test
	public void testgetKleinstesElement() {
		ArrayListe<Integer> test = new ArrayListe<Integer>();
		test.hinzufuegen(1);
		test.hinzufuegen(2);
		test.hinzufuegen(3);
		test.hinzufuegen(4);
		test.hinzufuegen(5);
		assertEquals("Error!", (int) test.<Integer> getKleinstesElement(), 1);
	}

	@Test
	public void testGet() {
		ArrayListe<String> test = new ArrayListe<String>();
		test.hinzufuegen(null);
		test.hinzufuegen("hello");
		assertEquals("Error", test.get(0), null);
		assertEquals("Error", test.get(1).equals("hello"), true);
	}

	@Test
	public void testSum() {
		ArrayListe<Integer> test = new ArrayListe<Integer>();
		test.hinzufuegen(115);
		test.hinzufuegen(427);
		test.hinzufuegen(436);
		test.hinzufuegen(67);
		test.hinzufuegen(23);
		try {
			assertEquals("Error!", test.sum(), 1068);
		} catch (Exception e) {
		}
		ArrayListe<String> test1 = new ArrayListe<String>();
		test1.hinzufuegen("hi");
		test1.hinzufuegen("help");
		try {
			assertEquals("Error!", test1.sum(), 0);
		} catch (Exception e) {
		}
	}
}
