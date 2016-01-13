package Aufgabenblatt4;

import java.util.ArrayList;
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
	
	public List<Polygon> getListeMitPolygonen() {
		return listeMitPolygonen;
	}

	public Polygon getAktuellesPolygon() {
		return aktuellesPolygon;
	}

	/**
	 * Konstruktor
	 * @param listeMitPolygonen
	 * @param aktuellesPolygon
	 */
	public PolygonModell() {
		this.listeMitPolygonen = new ArrayList<Polygon>();
		this.aktuellesPolygon = new Polygon();
		aktuellesPolygon.addObserver(this);
	}

	public void polygonbearbeitungAbschliessen(){	
		listeMitPolygonen.add(aktuellesPolygon);
		aktuellesPolygon = new Polygon();
		aktuellesPolygon.addObserver(this);
		setChanged();
		notifyObservers();
	}

	public void punkthinzufuegen(int x, int y){
		aktuellesPolygon.punkthinzufuegen(x, y);
		System.out.println("Der Punkt"+ x + ""+ y +"wurde hinzugefügt.");
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		setChanged();
		notifyObservers();
	}
	
}
