package Aufgabenblatt1;


/** Pruefungsleistung
 * 
 * Eine Klasse die Pruefungsleistung verwaltet mit Modulen und Noten.
 * 
 * @author Anushavan Melkonyan
 *
 */

public class Pruefungsleistung {

	
	private String modul;
	private int note;
	
/** Konstruktor
 * 
 * @param modul
 * @param note
 */
	Pruefungsleistung(String modul, int note){
		this.modul = modul;
		this.note = note;
	}
	@Override
	public String toString(){
		return modul+" "+note;
	}
}
