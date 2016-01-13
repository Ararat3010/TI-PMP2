package Aufgabenblatt4;


import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;



import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class PolygonDarstellung extends Canvas implements Observer {
	
	private PolygonModell polygonmodell;
	
	private GraphicsContext gc;
	

	public PolygonDarstellung(PolygonModell polygonmodell) {
		super(400,350);
		this.polygonmodell = polygonmodell;
		this.polygonmodell.addObserver(this);
		this.gc = getGraphicsContext2D();
		gc.clearRect(0, 0, getWidth(), getHeight());
//		gc.fillRect(0, 0, getWidth(), getHeight());
		addEventHandler(MouseEvent.MOUSE_CLICKED, new MausKlickEventHandler(polygonmodell));
	}

	public void polygonModellZeichnen(){
		if(this.polygonmodell != null){
			for(Polygon p : this.polygonmodell.getListeMitPolygonen()){
				polygonZeichnen(p,Color.BLACK);
			}
			polygonZeichnen(polygonmodell.getAktuellesPolygon(),Color.LAWNGREEN);
		}
	}
	
	public void polygonZeichnen(Polygon p, Color farbe){
		gc.setStroke(farbe);
		Punkt letzterPunkt = null;
		if(p != null){
			List<Punkt> liste = p.getPunkt();
			for(Punkt punkt : liste){
				gc.strokeOval(punkt.getX() -2, punkt.getY() -2, 4, 4);
				if(letzterPunkt != null){
					gc.strokeLine(letzterPunkt.getX(), letzterPunkt.getY(), punkt.getX(), punkt.getY());
				}
				letzterPunkt = punkt;
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		gc.clearRect(0, 0, getWidth(), getHeight());
		polygonModellZeichnen();
		
	}

}
