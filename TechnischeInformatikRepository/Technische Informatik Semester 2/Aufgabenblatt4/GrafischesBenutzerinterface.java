package Aufgabenblatt4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GrafischesBenutzerinterface extends Application{
	
	private PolygonModell modell;

	private TableView<Polygon> tabelle;
	
	private ObservableList<Polygon> polygone;

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Zeicheneditor");
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(1);
		gridpane.setVgap(1);
		
		BorderPane root = new BorderPane();
		modell = new PolygonModell();
		PolygonDarstellung zeichenflaeche = new PolygonDarstellung(modell);
		
		
		//Button
		Button button = new Button("Setzen/Neu");

//		button.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent event){
//				modell.polygonbearbeitungAbschliessen();
//				tabelleUpdaten();}
//		});
		button.setOnAction(e -> {
			modell.polygonbearbeitungAbschliessen();
			tabelleUpdaten();
		});
		gridpane.add(button, 0, 0);
		
		//Tabelle
		tabelle = new TableView<>();
		tabelle.setPrefWidth(200);
		tabelle.setPrefHeight(300);
		tabelle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		TableColumn<Polygon,String> firstNameCol = new TableColumn<>("Polygone");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Polygon, String>("beschreibung"));
		polygone = FXCollections.<Polygon>observableArrayList(modell.getListeMitPolygonen());
		tabelle.setItems(polygone);
		tabelle.getColumns().add(firstNameCol);
		
		gridpane.add(tabelle, 0, 1);
		
		//Textfeld
		TextField textfeld = new TextField("bewege -> x,y");
		gridpane.add(textfeld, 0, 2);
		
		//Button
		Button button2 = new Button("Eingabe");
		button2.setOnAction(e-> {
			PolygonSkripting skript = new PolygonSkripting(textfeld.getText());
			skript.bearbeiten();
			if(skript.getKommando().equalsIgnoreCase("bewege")&&skript.gueltig()){
				modell.punkthinzufuegen(skript.getX(), skript.getY());
			}
		});
		gridpane.add(button2, 0, 3);
		
	
		root.setRight(gridpane);
		root.setLeft(zeichenflaeche);


		primaryStage.setScene(new Scene(root,600,400));
		primaryStage.show();
	}
	
	private void tabelleUpdaten(){
		polygone=FXCollections.<Polygon>observableArrayList(modell.getListeMitPolygonen());
		tabelle.setItems(polygone);
	}
	
}
