package Aufgabenblatt4Neu;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Die Klasse repräsentiert ein Polygon
 *
 *
 */
public class Polygon extends Observable {

	/**
	 * Die innere Klasse bestimmt die x- und y- Koordinaten eines Punktes, eines
	 * Polygons
	 */
	private class Punkt {
		/**
		 * xKoordinate
		 */
		private double xKoordinate;
		/**
		 * yKoordinaten
		 */
		private double yKoordinate;

		/**
		 * Konstruktor
		 * 
		 * @param xKoordinaten
		 * 
		 * @param yKoordinaten
		 * 
		 */
		public Punkt(double xKoordinate, double yKoordinate) {
			this.xKoordinate = xKoordinate;
			this.yKoordinate = yKoordinate;
		}
	}

	/**
	 * Konstruktor
	 * 
	 * @param o
	 * 
	 */
	public Polygon(Observer o) {
		punkte = new ArrayList<Punkt>();
		addObserver(o);
	}

	/**
	 * Variable punkte vom Typ List<Punkt>
	 */
	private List<Punkt> punkte;
	/**
	 * Variable info vom Typ String
	 */
	private String info;

	/**
	 * Getter
	 * 
	 * @return Gibt die Punkte wieder
	 */
	public List<Punkt> getListePunkte() {
		return punkte;
	}

	/**
	 * Setter
	 *
	 * @param x
	 * 
	 * @param y
	 * 
	 */
	public void setPunkt(double x, double y) {
		punkte.add(new Punkt(x, y));
		setChanged();
		notifyObservers();
	}

	/**
	 * Getter
	 * 
	 * @param index
	 * 
	 * @return Liefert die x-Koordinate am Index
	 */
	public double getXAtIndex(int index) {
		if (index >= 0 && index < punkte.size()) {
			return punkte.get(index).xKoordinate;
		} else {
			throw new IndexOutOfBoundsException("Index ist nicht vorhanden");
		}
	}

	/**
	 * Getter
	 * 
	 * @param index
	 * 
	 * @return Liefert die y-Koordinate am Index
	 */
	public double getYAtIndex(int index) {
		if (index >= 0 && index < punkte.size()) {
			return punkte.get(index).yKoordinate;
		} else {
			throw new IndexOutOfBoundsException("Index ist nicht vorhanden");
		}
	}

	/**
	 * Überschreiben der toString Methode
	 * 
	 * @return Info über die Anzahl der Punkte eines Polygons
	 */
	@Override
	public String toString() {
		String punkteAnz = Integer.toString(punkte.size());
		if (punkte.size() > 1 || punkte.size() == 0) {
			punkteAnz += " Punkten";
		} else {
			punkteAnz += " Punkt";
		}
		info = "Polygon mit " + punkteAnz;
		return info;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Info des Polygons zurueck
	 */
	public String getInfo() {
		return info;
	}

}
