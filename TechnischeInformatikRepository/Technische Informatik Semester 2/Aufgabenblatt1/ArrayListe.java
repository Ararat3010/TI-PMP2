package Aufgabenblatt1;

/**
 *
 * ArrayListe
 *
 * Eine Klasse die eine Arrayliste darstellt
 *
 *
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 *
 *         Aufgabe: Aufgabenblatt 1, Aufgabe 4
 *
 * @param <T>
 *
 */
public class ArrayListe<T> {
	private int anzahlElemente;
	private Object[] elemente;

	public ArrayListe() {
		this(0);
	}

	/**
	 * Konstruktor
	 *
	 * @param groesse
	 */
	public ArrayListe(int groesse) {
		elemente = new Object[groesse];
		anzahlElemente = 0;
	}

	/**
	 * Hinzufuegen der Elemente in die Liste
	 *
	 * @param element
	 */
	public void hinzufuegen(T element) {
		Object[] neuElementeArray = new Object[elemente.length + 1];
		for (int i = 0; i < elemente.length; i++) {
			neuElementeArray[i] = elemente[i];
		}
		anzahlElemente = neuElementeArray.length;
		neuElementeArray[elemente.length] = element;
		elemente = neuElementeArray;
	}

	/**
	 * Getter
	 *
	 * @param index
	 * @return wenn nichts gefunden wird soll er Null zurueckgeben, ansonsten
	 *         gibt er das Element an dem angegebenen Index zurueck.
	 *
	 */
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (index < anzahlElemente && index >= 0) {
			return (T) elemente[index];
		} else {
			return null;
		}
	}

	/**
	 * Element aus der Liste entfernen
	 *
	 * @param element
	 *            welches entfernt werden soll
	 */

	/**
	 * Entfernen von einem T objekt aus der Liste.
	 *
	 * @param element
	 */
	public void entfernen(T element) {
		if (element == null){
			throw new ArrayIndexOutOfBoundsException("Zahl nicht vorhanden");
		}
		Boolean istEntfernt = false;
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] == element) {
				elemente[i] = null;
				istEntfernt = true;
				break;
			}
		}
		if (istEntfernt == true) {
			aufrauemenArray();
		}
	}

	/**
	 * Verkleinert das Array um ein Element.
	 */
	private void aufrauemenArray() {
		int neueLaenge = elemente.length - 1;
		Object[] newElementeArray = new Object[neueLaenge];
		int c = 0;
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] != null) {
				newElementeArray[c] = elemente[i];
				c++;
			}
		}
		elemente = newElementeArray;
		anzahlElemente = elemente.length;
	}

	/**
	 * Entfernt ein Element aus der Liste an einen Ã¼bergebenen index.
	 *
	 * @param index
	 */
	public void entfernenElementeAnIndex(int index) {
		elemente[index] = null;
		aufrauemenArray();
	}

	/**
	 *
	 * Getter Ausgabe der Anzahl
	 *
	 * @return
	 */
	public int getAnzahlElemente() {
		return elemente.length;
	}

	/**
	 * ToString Methode
	 *
	 */
	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < anzahlElemente; i++) {
			ausgabe += elemente[i];
		}
		return ausgabe;
	}

	/**
	 * Gibt das kleinste Element
	 *
	 * @return
	 */
	public <T extends Comparable<T>> T getKleinstesElement() {
		T kleinstesElement = (T) elemente[0];
		for (int i = 1; i < anzahlElemente; i++) {
			if (kleinstesElement.compareTo((T) elemente[i]) > 0) {
				kleinstesElement = (T) elemente[i];
			}
		}
		return kleinstesElement;
	}

	/**
	 * Wenn Integerelemente enthalten sind, dann wird Summiert
	 *
	 * @return sonst wird 0 zurueckgegeben
	 */
	public int sum() {
		int result = 0;
		int i = 0;
		while (i < this.elemente.length) {
			if (this.elemente[i] instanceof Integer) {
				result += (Integer) this.elemente[i];
			}
			i++;
		}
		return result;
	}
}




