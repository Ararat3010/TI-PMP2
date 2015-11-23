package Aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

/** TestKlasse für Studenten
 * 
 * @author Anushavan Melkonyan
 *
 */
public class StudentTest {

	@Test
	public void testVergleichMitMatrikelnummer() {
		Student student1 = new Student("Alina","Petrovna", 3456789);
		Student student2 = new Student("Peter","Buschman", 3456786);
		
/** Vergleich nach der Matrikelnummer*/
		assertEquals("Fehler", student1.compareTo(student2),3);
		assertEquals("Fehler", student2.compareTo(student1),-3);
		assertEquals("Fehler", student1.compareTo(student1),0);
	}
		
		@Test
		public void testVergleichMitVornameNachname() {
			Student student1 = new Student("Alina","Petrovna", 3456789);
			Student student2 = new Student("Peter","Buschman", 3456786);
			Student student3 = new Student("Peter","Buschman", 3456786);
			Student student4 = new Student("Petera","Buschman", 3456786);
			
			NachnameVergleicher vergleicher = new NachnameVergleicher();
			
			
/** Vergleich nach VornameNachname*/
		assertEquals(vergleicher.compare(student1, student2), 14);
		assertEquals(vergleicher.compare(student3, student2), 0);
		assertEquals(vergleicher.compare(student3, student4), -1);
		
	}

}
