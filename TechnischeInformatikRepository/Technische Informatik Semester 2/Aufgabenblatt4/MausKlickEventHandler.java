package Aufgabenblatt4;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MausKlickEventHandler implements EventHandler<MouseEvent>{

	PolygonModell polymodell;
	
	public MausKlickEventHandler(PolygonModell polymodell) {
		this.polymodell = polymodell;
	}

	@Override
	public void handle(MouseEvent event) {
		System.out.println(event.getSceneX()+", "+ event.getSceneY());
		this.polymodell.getAktuellesPolygon().punkthinzufuegen((int)event.getSceneX(),(int) event.getSceneY());
	}

}
