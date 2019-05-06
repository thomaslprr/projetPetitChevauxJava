package mesClasses;

import java.util.ArrayList;

/**
 * Classe Case
 * @author Thomas Lapierre
 */

public abstract class Case {
	private ArrayList<Pion> pionCase = new ArrayList<Pion>();
	private static int nombreCaseTotale = 0;
	
	public Case() {
		Case.nombreCaseTotale++;
		pionCase.clear();
	}
	
	public ArrayList<Pion> getChevaux(){
		
		return pionCase;
	}
	
	public void ajouteCheval(Pion pion) {
		pionCase.add(pion);
	}
	
	public void retirerCheval(Pion pion) {
		pionCase.remove(pion);
	}

	public int getCaseTotale() {
		return nombreCaseTotale;
	}
	
	
	public abstract boolean peutPasser(Pion pion);
	
	public abstract boolean peutSArreter(Pion pion);

}