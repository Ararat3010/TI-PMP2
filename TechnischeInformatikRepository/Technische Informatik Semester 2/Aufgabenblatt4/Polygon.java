package Aufgabenblatt4;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Polygon extends Observable {
	
	/**
	 * Liste mit Punkten
	 */
	private List<Punkt> polygon = new LinkedList<Punkt>();
	
	/**
	 * Setzt einen neuen Punkt in die Liste
	 * @param punkt
	 */
	public void setPolygon(Punkt punkt){
		this.polygon.add(punkt);
		setChanged();
		notifyObservers();
	}
}
