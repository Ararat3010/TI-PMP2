package Aufgabenblatt1;

import java.util.Comparator;

public class NachnameVergleicher implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		
		int student = o1.getNachname().compareTo(o2.getNachname());
		if (student == 0)
		{ 
				return o1.getVorname().compareTo(o2.getVorname());
		}
		return student;
	}

}
