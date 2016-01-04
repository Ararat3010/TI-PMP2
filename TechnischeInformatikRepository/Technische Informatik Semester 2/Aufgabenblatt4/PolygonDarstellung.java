package Aufgabenblatt4;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

public class PolygonDarstellung extends BorderLayout implements Observer {
	
	private PolygonModell polygonmodell;
	
	
	
	public PolygonDarstellung(PolygonModell polygonmodell) {
		this.polygonmodell = polygonmodell;
	}

	public void polygonZeichnen(){
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
