package mesClasses;

import java.util.ArrayList;

/**
 * Classe Case
 * @author Thomas Lapierre
 */

public abstract class Case {
	private ArrayList<Pion> pionCase = new ArrayList<Pion>();
	private static int compteurCase = 1 ;
	private int numeroCase ; 
	
	public Case() {
		numeroCase=compteurCase;
		compteurCase++;
		pionCase.clear();
	}
	
	public ArrayList<Pion> getChevaux(){
		
		return pionCase;
	}
	
	public void ajouteCheval(Pion pion) {
		pionCase.add(pion);
	}

	public int getCaseJoueur() {
		return numeroCase;
	}
	
	public abstract boolean peutPasser(Pion pion);
	
	public abstract boolean peutSArreter(Pion pion);

}