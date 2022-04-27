package it.polito.tdp.parole.model;
import java.util.Comparator; 

public class Ordine implements Comparator <Object> {

	@Override
	public int compare (Object o1, Object o2) {
		String p1= (String)o1; 
		String p2= (String)o2; 
		
		return p1.compareTo(p2); 
	}

}
