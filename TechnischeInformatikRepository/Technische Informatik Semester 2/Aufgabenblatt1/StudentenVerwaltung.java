package Aufgabenblatt1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StudentenVerwaltung {

	public static void main(String[] args) {

		List<Student> liste1 = new LinkedList<Student>();
		liste1.add(new Student("Peter", "Maier", 323456783));
		liste1.add(new Student("Martin", "Horst", 323456782));
		liste1.add(new Student("Maria", "Hoffman", 323456787));
		liste1.add(new Student("Alina", "Gehweg", 323456785));
		liste1.add(new Student("Anton", "Dawai", 323456789));
		liste1.add(new Student("Beton", "Dawai", 323456789));
		liste1.get(0).addPruefungsleistung(new Pruefungsleistung("Db", 3));
		liste1.get(0).addPruefungsleistung(new Pruefungsleistung("AF", 2));
		liste1.get(0).addPruefungsleistung(new Pruefungsleistung("GS", 4));
		liste1.get(0).addPruefungsleistung(new Pruefungsleistung("PMP", 6));
		liste1.get(0).addPruefungsleistung(new Pruefungsleistung("GE", 5));
		liste1.get(0).printLeistung();
		System.out.println("------------------------");
		System.out.println("Liste unsortiert" + "\n");
		for (Student stud1 : liste1) {
			System.out.println(stud1);

		}
		System.out.println("------------------------");
		System.out.println("Liste nach Matrikelnummer sortiert" + "\n");
		Collections.sort(liste1);
		for (Student stud1 : liste1)

		{
			System.out.println(stud1);

		}
		System.out.println("------------------------");
		System.out.println("Liste nach Nachnamen sortiert" + "\n");
		Collections.sort(liste1, new NachnameVergleicher());
		for (Student stud1 : liste1) {
			System.out.println(stud1);

		}

	}

}
