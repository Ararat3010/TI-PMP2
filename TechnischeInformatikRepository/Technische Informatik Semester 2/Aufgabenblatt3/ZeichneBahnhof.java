package Aufgabenblatt3;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * 
 * In dieser Klasse wird unser Bahnhof dargestellt
 * werden, welche die Zuege Ein-und Ausfahren.
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 3, Aufgabe 4
 */

public class ZeichneBahnhof {

	public Path leeresGleis() {

		Path bahnhof = new Path();
		bahnhof.setStroke(Color.BLACK);
		MoveTo moveTo2 = new MoveTo();
		moveTo2.setX(200);
		moveTo2.setY(0);
		LineTo lineTo5 = new LineTo();
		lineTo5.setX(0);
		lineTo5.setY(0);
		LineTo lineTo6 = new LineTo();
		lineTo6.setX(0);
		lineTo6.setY(100);
		LineTo lineTo7 = new LineTo();
		lineTo7.setX(200);
		lineTo7.setY(100);

		bahnhof.getElements().add(moveTo2);
		bahnhof.getElements().add(lineTo5);
		bahnhof.getElements().add(lineTo6);
		bahnhof.getElements().add(lineTo7);

		return bahnhof;

	}
	
	public Path besetztesGleis(){


		// Zug
		MoveTo moveTo = new MoveTo();
		moveTo.setX(10);
		moveTo.setY(90);
		LineTo lineTo1 = new LineTo();
		lineTo1.setX(190);
		lineTo1.setY(90);
		LineTo lineTo2 = new LineTo();
		lineTo2.setX(190);
		lineTo2.setY(10);
		LineTo lineTo3 = new LineTo();
		lineTo3.setX(10);
		lineTo3.setY(10);
		LineTo lineTo4 = new LineTo();
		lineTo4.setX(10);
		lineTo4.setY(90);

		
		Path bahnhof = new Path();
		bahnhof.setStroke(Color.BLACK);
		MoveTo moveTo2 = new MoveTo();
		moveTo2.setX(200);
		moveTo2.setY(0);
		LineTo lineTo5 = new LineTo();
		lineTo5.setX(0);
		lineTo5.setY(0);
		LineTo lineTo6 = new LineTo();
		lineTo6.setX(0);
		lineTo6.setY(100);
		LineTo lineTo7 = new LineTo();
		lineTo7.setX(200);
		lineTo7.setY(100);

		bahnhof.getElements().add(moveTo2);
		bahnhof.getElements().add(lineTo5);
		bahnhof.getElements().add(lineTo6);
		bahnhof.getElements().add(lineTo7);
		bahnhof.getElements().add(moveTo);
		bahnhof.getElements().add(lineTo1);
		bahnhof.getElements().add(lineTo2);
		bahnhof.getElements().add(lineTo3);
		bahnhof.getElements().add(lineTo4);
		
		
		return bahnhof;
	}

}
