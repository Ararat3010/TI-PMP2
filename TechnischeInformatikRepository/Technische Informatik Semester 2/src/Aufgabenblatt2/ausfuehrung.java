package Aufgabenblatt2;
/**
* @author Bennet Honisch (Bennet.honisch@haw-hamburg.de)
* @autho Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de)
*/
import java.util.*;

public class ausfuehrung {
	public static void main(String[] args) {

		//erstellen der Autos fuer das Rennen
		Rennauto auto1 = new Rennauto(1,10);
		Rennauto auto2 = new Rennauto(1,10);
		Rennauto auto3 = new Rennauto(1,10);
		//benennen der Autos
		auto1.setName("Wagen1");
		auto2.setName("Wagen2");
		auto3.setName("Wagen3");
		//erstellen einer Autoliste
		List<Rennauto> autoListe = new ArrayList<Rennauto>();
		//hinzufuegen der Autos in die Liste
		autoListe.add(auto1);
		autoListe.add(auto2);
		autoListe.add(auto3);
		//erstellen eines Rennabbruchs
		Rennabbruch rennabbruch = new Rennabbruch(auto1,auto2,auto3,10);
		//starten des Rennens
		auto1.start();
		auto2.start();
		auto3.start();
		rennabbruch.start();
		
		//einfangen der Autos nach dem Rennen
		try{
			auto1.join();
			auto2.join();
			auto3.join();
			//wagen4.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Ergebnis\n");
		//sortieren der Autos nach benötigter Zeit
		autoListe.sort(null);
		for (Rennauto auto : autoListe) {
			  System.out.println(auto.getName() + ": " + auto.getZeit());
			}


		
	}
}
