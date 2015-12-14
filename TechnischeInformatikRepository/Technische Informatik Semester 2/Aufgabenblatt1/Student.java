package Aufgabenblatt1;

import java.util.ArrayList;


/**
*
* Student
*
* Eine Klasse die Vornamen, Nachnamen sowie Matrikelnummer ausgibt 
* sowie Pruefungsleistungen in einer Liste für jeden Studenten.
*
* 
* Praktikum TIPR2, WS 2015
* 
* @author Anushavan Melkonyan (Anushavan.Melkonyan@haw-hamburg.de),
* 
*         Aufgabe: Aufgabenblatt 1, Aufgabe 2
*
*
*/


public class Student implements Comparable<Student>{
	
	private String vorname; 
	private String nachname; 
	private int matrikelnummer;
	private ArrayList<Pruefungsleistung> liste = new ArrayList<Pruefungsleistung>();
	
	public void printLeistung(){
		System.out.println(this);
		
		for (Pruefungsleistung fach : getPruefungsleistung())
		{
			System.out.println("Fach: "+fach);
		}
	}
/** Konstruktor
 * 
 * @param vorname
 * @param nachname
 * @param martikelnummer
 */
	public Student(String vorname, String nachname, int martikelnummer ){
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = martikelnummer;
		
	}
	 
	
	public String getVorname(){
		return vorname;
	}
	
	public String getNachname(){
		return nachname;
	}
	
	public int getMatrikelnummer(){
		return matrikelnummer;
	}

	@Override
	public String toString(){
		
		return nachname+" "+vorname+" "+matrikelnummer;
	}
	
/** Matrikelnummer vergleich*/
	@Override
	public int compareTo(Student student) {
		
		return matrikelnummer - student.getMatrikelnummer();
	}
	
	public void addPruefungsleistung(Pruefungsleistung pm){
		liste.add(pm);
		
	}
	
	public ArrayList<Pruefungsleistung> getPruefungsleistung(){
		return liste;
	}

}
