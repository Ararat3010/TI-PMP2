package Aufgabenblatt4;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Aufgabenblatt1.ArrayListe;

public class Polygon extends Observable {
	
	/**
	 * Liste mit Punkten
	 */
	private List<Punkt> punkt;
	private String beschreibung;
	
	public List<Punkt> getPunkt() {
		return punkt;
	}

	
	public Polygon(){
		punkt = new ArrayList<Punkt>();
		beschreibung = "Es wurden 0 Punkte hinzugefuegt.";
	}
	/**
	 * Setzt einen neuen Punkt in die Liste
	 * @param punkt
	 */
	
	public void punkthinzufuegen(int a, int b){
		punkt.add(new Punkt(a,b));
		setChanged();
		notifyObservers();
		beschreibung = "Es wurden "+ punkt.size() + " Punkte hinzugefuegt";
	}
	public String getBeschreibung(){
		return this.beschreibung;
	}
}
