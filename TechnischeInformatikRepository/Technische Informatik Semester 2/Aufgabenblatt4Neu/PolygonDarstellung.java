package Aufgabenblatt4Neu;

import java.util.Observable;
import java.util.Observer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Die Klasse stellt Polygone dar
 * 
 *
 */
public class PolygonDarstellung extends Canvas implements Observer {
	/**
	 * Variable gc vom Typ GraphicsContext
	 */
	private GraphicsContext gc;
	/**
	 * Variable root vom Typ StackPane
	 */
	private StackPane root;
	/**
	 * Variable listener vom Typ InvalidationListener
	 */

	/**
	 * Variable modell vom Typ PolygonModell
	 */
	private PolygonModell modell;

	/**
	 * Getter
	 * 
	 * @return Modell
	 */
	public PolygonModell getModell() {
		return modell;
	}

	/**
	 * Setter
	 * 
	 * @param modell
	 * 
	 */
	public void setModell(PolygonModell modell) {
		this.modell = modell;
	}

	/**
	 * Die Methode setzt die Größe des Feldes zum Zeichnen
	 */
	public void setWindow() {
		setWidth(root.getLayoutBounds().getWidth());
		setHeight(root.getLayoutBounds().getHeight());
	}

	/**
	 * Die Methode löscht alle Elemente des Feldes
	 */
	public void clearScreen() {
		gc.clearRect(0, 0, getWidth(), getHeight());
		gc.fillRect(0, 0, getWidth(), getHeight());
	}

	/**
	 * Kostruktor StackPane auf welcher das Polygon entstehen soll
	 * 
	 * @param pane
	 */
	public PolygonDarstellung(StackPane pane) {
		super(400, 350);
		gc = getGraphicsContext2D();
		gc.setFill(Color.HONEYDEW);
		gc.setStroke(Color.BLACK);
		pane.getChildren().add(this);
		root = pane;

		addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Polygon aktuellesPolygon = modell.getPolygon();
				aktuellesPolygon.setPunkt(event.getX(), event.getY());
				event.consume();
			}
		});
	}

	/**
	 * Die Methode erstellt eine Zeichnung des Polygons
	 * 
	 * @param polygon
	 * @param farbe
	 */
	private void polygonZeichnung(Polygon polygon, Color farbe) {
		if (polygon != null) {
			gc.setStroke(farbe);
			for (int i = 0; i < polygon.getListePunkte().size(); i++) {
				double x1 = polygon.getXAtIndex(i);
				double y1 = polygon.getYAtIndex(i);
				double x2;
				double y2;
				gc.strokeOval(x1 - 2.5, y1 - 2.5, 5, 5);
				if (i + 1 >= polygon.getListePunkte().size()) {
					x2 = polygon.getXAtIndex(i);
					y2 = polygon.getYAtIndex(i);
				} else {
					x2 = polygon.getXAtIndex(i + 1);
					y2 = polygon.getYAtIndex(i + 1);
				}
				gc.strokeLine(x1, y1, x2, y2);
			}
		}
	}

	/**
	 * Die Methode zeichnet das Polygon
	 * 
	 * @param poly
	 * 
	 */
	public void zeichnePolygon(Polygon poly) {
		polygonZeichnung(poly, Color.ORANGE);
	}

	/**
	 * Die Methode Zeichnet das fertige Polygon
	 */
	public void zeichneFertigePolygone() {
		for (int i = 0; i < modell.getListePolygone().size(); i++) {
			polygonZeichnung(modell.getListePolygone().get(i), Color.BLACK);
		}
	}

	/**
	 * Die Methode updatet das Feld
	 */
	@Override
	public void update(Observable o, Object arg) {
		clearScreen();
		zeichnePolygon(modell.getPolygon());
		zeichneFertigePolygone();
	}
}
