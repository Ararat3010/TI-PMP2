package Aufgabenblatt2;

import java.util.*;

/**
 * Klasse Rennen repräsentiert unsere Fahrzeuge auf der Rennstrecke
 * 
 * Praktikum TIPR2, WS 2015
 *
 * @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
 * @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
 * 
 *         Aufgabe: Aufgabenblatt 2, Aufgabe 3
 */

public class Rennen {

	public static void main(String[] args) {

		// erstellen der Autos fuer das Rennen
		Rennauto auto1 = new Rennauto("Ferrari", 1, 10);
		Rennauto auto2 = new Rennauto("Mercedes", 1, 10);
		Rennauto auto3 = new Rennauto("McLaren", 1, 10);
		Rennauto auto4 = new Rennauto("Infinity", 1, 10);

		// benennen der Fahrer
		auto1.setName("Vettel");
		auto2.setName("Hamilton");
		auto3.setName("Alonso");
		auto4.setName("Ricciardo");

		// erstellen einer Autoliste
		List<Rennauto> autoliste = new ArrayList<Rennauto>();

		// hinzufuegen der Autos in die Liste
		autoliste.add(auto1);
		autoliste.add(auto2);
		autoliste.add(auto3);
		autoliste.add(auto4);

		// erstellen eines Rennabbruchs
		Rennabbruch rennabbruch = new Rennabbruch(autoliste, 10);

		// starten des Rennens
		for (Rennauto rennauto : autoliste) {
			rennauto.start();
		}
		rennabbruch.start();

		// einfangen der Autos nach dem Rennen
		try {
			for (Rennauto rennauto : autoliste) {
				rennauto.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// sortieren der Autos nach benoetigter Zeit
		System.out.println("Ergebnis\n");
		autoliste.sort(null);
		for (Rennauto auto : autoliste) {
			System.out.println(auto.toString());
		}

	}
}
