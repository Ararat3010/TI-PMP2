package Aufgabenblatt4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GrafischesBenutzerinterface extends Application{
//	Polygondarstellung darstellung = new 
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
		
		//Button
		Button button = new Button("Setzen/Neu");
		gridpane.add(button, 0, 0);
		
		//Tabelle
		TableView<Polygon> tabelle = new TableView<>();
		tabelle.setPrefWidth(150);
		tabelle.setPrefHeight(300);
		gridpane.add(tabelle, 0, 1);
		
		//Textfeld
		TextField textfeld = new TextField();
		textfeld.setPromptText("Bitte einen Befehl eingeben");
		gridpane.add(textfeld, 0, 2);
		
		//Button
		Button button2 = new Button("Eingabe");
		gridpane.add(button2, 0, 3);
		
		root.setRight(gridpane);
//		root.getChildren().add(gridpane);
		
		primaryStage.setScene(new Scene(root,600,400));
		primaryStage.show();
	}
	
}
