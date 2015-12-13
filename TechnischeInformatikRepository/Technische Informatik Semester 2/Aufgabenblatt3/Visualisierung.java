package Aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Diese Klasse repraesentiert die Visualisierung des Gueterzugbahnhofs
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
 *
 */
public class Visualisierung extends Application implements Observer {

	/**
	 * Variable fuer den gezeichneten Bahnhof
	 */
	private ZeichneBahnhof zeichneBahnhof;

	/**
	 * Variable fuer die Simulation
	 */
	private Simulation simulation;

	/**
	 * Variable fuer die Gridpane
	 */
	private GridPane gridPane;

	/**
	 * Konstruktor fuer die Visualisierung
	 */
	public Visualisierung() {
		simulation = new Simulation(new Rangierbahnhof(3));
		zeichneBahnhof = new ZeichneBahnhof();
		gridPane = new GridPane();
	}

	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * Erstellen einer Gridpane. Erstellen einer Stage. Erstellen eines leeren Bahnhofs.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ein Gueterzugbahnhof");

		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(1);
		gridPane.setVgap(1);
		Pane root = new Pane();
		root.getChildren().add(gridPane);

		this.simulation.addObserver(this);

		for (int i = 0; i < 3; i++) {
			gridPane.add(this.zeichneBahnhof.leeresGleis(), 0, i);
		}

		primaryStage.setScene(new Scene(root, 220, 320));
		primaryStage.show();
		new Thread(simulation).start();

	}

	/**
	 * Diese Methode updated unsere Visualisierung. 
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Simulation) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<3;i++){
						if(simulation.getBahnhof().getGleise(i)!=null){
							gridPane.add(zeichneBahnhof.besetztesGleis(), 0, i);
						}else
							gridPane.add(zeichneBahnhof.leeresGleis(), 0, i);
					}
				}
			}

			);
		}

	}

}
