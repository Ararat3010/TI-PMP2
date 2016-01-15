package Aufgabenblatt4Neu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Die Klasse stellt das Benutzerinterface dar
 * 
 *
 */
public class JavaFxGUI extends Application {

	private GridPane gridpane = new GridPane();
	/**
	 * Variable primaryStage vom Typ Stage
	 */
	private Stage primaryStage;
	/**
	 * Variable pane vom Typ Pane
	 */
	private Pane pane;
	/**
	 * Variable tabelle vom Typ TableVie<Polygon>
	 */
	private TableView<Polygon> tabelle;
	/**
	 * Variable polygonTabelle vom Typ PolygonTabelle
	 */
	private PolygonTabelle polygonTabelle;
	/**
	 * Variable flaeche vom Typ TextArea
	 */
	private TextField flaeche;
	/**
	 * Variable regulaererAusdruck vom Typ PolygonSkripting
	 */
	private PolygonSkripting regulaererAusdruck = new PolygonSkripting();
	/**
	 * Variablen width und height vom Typ int definiert die Fensterseitenlängen
	 */
	private final int width, height;
	/**
	 * Variable zeichenFlaeche vom Typ PolygonDarstelung
	 */
	private PolygonDarstellung zeichenFlaeche;

	/**
	 * Konstruktor
	 */
	public JavaFxGUI() {
		height = 400;
		width = 600;
	}

	/**
	 * Getter
	 * 
	 * @return pane
	 */
	public Pane getPane() {
		return pane;
	}

	/**
	 * Die Methode erstellt die GUI
	 * 
	 * @return pane
	 */
	private Pane erstellePane() {
		BorderPane pane = new BorderPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(1);
		gridpane.setVgap(1);
		gridpane.add(setzenfertigButton(), 0, 0);
		gridpane.add(polygonTabelle(), 0, 1);
		gridpane.add(befehlInput(), 0, 2);
		gridpane.add(eingabeButton(), 0, 3);
		pane.setCenter(zeichenflaeche());
		pane.setRight(gridpane);
		return pane;
	}

	/**
	 * Die Methode erstellt die Buttons
	 * 
	 * @return pane
	 */
	private Pane eingabeButton() {
		HBox pane = new HBox();
		Button befehl = new Button("Eingabe");
		befehl.setOnAction(event -> {
			String text = flaeche.getText();
			try {
				zeichenFlaeche.getModell().getPolygon().setPunkt(regulaererAusdruck.getX(text),
						regulaererAusdruck.getY(text));
				flaeche.clear();
			} catch (Exception e) {
				flaeche.setText("Ungültiger Befehl!");
			}
		});
		pane.getChildren().add(befehl);
		return pane;
	}

	private Pane setzenfertigButton() {
		HBox pane = new HBox();
		Button fertig = new Button("Setzen/Neu");
		fertig.setOnAction(event -> {
			zeichenFlaeche.getModell().bearbeitungZuEnde();
			polygonTabelle.updateTabelle();
		});
		pane.getChildren().add(fertig);
		return pane;
	}

	/**
	 * Die Methode erstellt die Polygondarstellung
	 * 
	 * @return Gibt die PolygonDarstellung zurueck
	 */
	private Pane zeichenflaeche() {
		StackPane pane = new StackPane();
		zeichenFlaeche = new PolygonDarstellung(pane);
		return pane;
	}

	/**
	 * Die Methode erstellt die Befehlseingabe
	 * 
	 * @return pane
	 */
	private TextField befehlInput() {
		flaeche = new TextField("bewege -> x,y");
		return flaeche;
	}

	/**
	 * Die Methode erstellt eine Tabelle der Polygone
	 * 
	 * @return pane
	 */
	private Pane polygonTabelle() {
		BorderPane pane = new BorderPane();
		tabelle = new TableView<Polygon>();
		pane.setCenter(tabelle);
		return pane;
	}

	/**
	 * Die Methode baut die GUI
	 */
	@Override
	public void start(Stage primaryStagePar) {
		primaryStage = primaryStagePar;
		primaryStage.setTitle("Zeicheneditor");
		pane = erstellePane();
		primaryStage.setScene(new Scene(pane, width, height));
		PolygonModell modell = new PolygonModell(zeichenFlaeche);
		zeichenFlaeche.setModell(modell);
		polygonTabelle = new PolygonTabelle(this.tabelle, modell);
		polygonTabelle.erstelleTabelle();
		primaryStage.show();
	}

	/**
	 * Programmstart
	 */
	public static void main(String[] args) {
		launch(args);
	}
}