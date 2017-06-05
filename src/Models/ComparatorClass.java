package Models;

import java.util.Comparator;

public class ComparatorClass implements Comparator {

	@Override
	public int compare(Object e1, Object e2) {
		
		return e2.hashCode()-e1.hashCode();
	}

}