package Aufgabenblatt4Neu;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Die Klasse baut die Tabelle der Polygone
 *
 *
 */
public class PolygonTabelle {

	/**
	 * Variable tabelle vom Typ TableView<Polygon>
	 */
	private TableView<Polygon> tabelle;
	/**
	 * Variable modell vom Typ PolygonModell
	 */
	private PolygonModell modell;

	/**
	 * Konstruktor
	 * 
	 * @param tabelle
	 * 
	 * @param modell
	 */
	public PolygonTabelle(TableView<Polygon> tabelle, PolygonModell modell) {
		this.tabelle = tabelle;
		this.modell = modell;
	}

	/**
	 * Erstellt eine Tabelle mit Daten über die Polygone
	 */
	public void erstelleTabelle() {
		tabelle.setPrefWidth(200);
		tabelle.setPrefHeight(300);
		tabelle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		List<Polygon> polygone = new ArrayList<Polygon>(modell.getListePolygone());
		ObservableList<Polygon> daten = FXCollections.observableArrayList(polygone);
		TableColumn<Polygon, String> pOlygone = new TableColumn<>("Polygone");
		pOlygone.setCellValueFactory(new PropertyValueFactory<>("info"));
		tabelle.setItems(daten);
		tabelle.getColumns().add(pOlygone);
	}

	/**
	 * Aktualisiert die Tabelle bei neuen Daten
	 */
	public void updateTabelle() {
		tabelle.getItems().clear();
		List<Polygon> polygone = new ArrayList<Polygon>(modell.getListePolygone());
		final ObservableList<Polygon> daten = FXCollections.observableArrayList(polygone);
		tabelle.setItems(daten);
	}

}
