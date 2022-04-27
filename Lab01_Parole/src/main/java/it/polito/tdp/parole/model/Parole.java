package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		
	public Parole() {
		//TODO
	}
	
	List<String> parole = new LinkedList<String>();
	int i; 

	public void addParola(String p) 
	{
		parole.add(p);
		
	}
	
	public List<String> getElenco() 
	{
		Collections.sort(parole, new Ordine() );
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

	@Override
	public String toString() {
		return  parole + "\n";
	}
	


}
