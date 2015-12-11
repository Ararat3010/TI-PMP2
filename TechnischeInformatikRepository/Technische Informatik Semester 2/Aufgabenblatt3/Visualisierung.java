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

public class Visualisierung extends Application implements Observer {

	private ZeichneBahnhof zeichneBahn;

	private Simulation simulation;

	private GridPane gridPane;

	public Visualisierung() {

		simulation = new Simulation(new Rangierbahnhof(3));
		zeichneBahn = new ZeichneBahnhof();
		gridPane = new GridPane();

	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ein Gueterzugbahnhof");

		// Gitternetz
		// GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(1);
		gridPane.setVgap(1);
		Pane root = new Pane();
		root.getChildren().add(gridPane);

		this.simulation.addObserver(this);

		for (int i = 0; i < 3; i++) {
			gridPane.add(this.zeichneBahn.leeresGleis(), 0, i);
		}

		primaryStage.setScene(new Scene(root, 220, 320));
		primaryStage.show();
		new Thread(simulation).start();

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Simulation) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					if (simulation.getBahnhof().getGleise(0) == null) {
						gridPane.add(zeichneBahn.besetztesGleis(), 0, 0);
					} else {
						gridPane.add(zeichneBahn.leeresGleis(), 0, 0);
					}
					//gridPane.getChildren().clear();

				}

			});
		}

	}

}
