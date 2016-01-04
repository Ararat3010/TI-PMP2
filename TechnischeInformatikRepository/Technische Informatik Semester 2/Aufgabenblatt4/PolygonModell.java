package Aufgabenblatt4;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PolygonModell extends Observable implements Observer{
	
	/**
	 * Liste mit allen Polygonen
	 */
	private List<Polygon> listeMitPolygonen;
	
	/**
	 * Aktuelles bearbeitetes Polygon
	 */
	private Polygon aktuellesPolygon;
	
	/**
	 * Konstruktor
	 * @param listeMitPolygonen
	 * @param aktuellesPolygon
	 */
	public PolygonModell(List<Polygon> listeMitPolygonen, Polygon aktuellesPolygon) {
		this.listeMitPolygonen = listeMitPolygonen;
		this.aktuellesPolygon = aktuellesPolygon;
		aktuellesPolygon.addObserver(this);
	}

	public void polygonbearbeitungAbschliessen(){	
		listeMitPolygonen.add(aktuellesPolygon);
		Polygon neuesPolygon = new Polygon();
		neuesPolygon = aktuellesPolygon;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
}
