package Aufgabenblatt2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/* 
 * Klasse Rechner für die Berechnung der vier Grundrechenarten
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 *
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 1
 */
public class Rechner {

	private Map<Operation, BinaryOperator<Double>> mapRechenArten;

	public enum Operation {
		ADDITION, SUBTRAKTION, MULTIPLIKATION, DIVISION
	};

	/**
	 * Konstruktor
	 * 
	 */
	public Rechner() {

		mapRechenArten = new HashMap<Operation, BinaryOperator<Double>>();

		mapRechenArten.put(Operation.ADDITION, (x, y) -> x + y);
		mapRechenArten.put(Operation.SUBTRAKTION, (x, y) -> x - y);
		mapRechenArten.put(Operation.MULTIPLIKATION, (x, y) -> x * y);
		mapRechenArten.put(Operation.DIVISION, (x, y) -> x / y);
	}

	/*
	 * Benutzt die Lambda ausdruecke und verwendet die Werte
	 * 
	 * 
	 * @param berechnung
	 * 
	 * @param ersterWert
	 * 
	 * @param zweiterWert
	 * 
	 * @return
	 */
	public double berechne(Operation berechnen, double wert1, double wert2) {
		return mapRechenArten.get(berechnen).apply(wert1, wert2);
	}

}
