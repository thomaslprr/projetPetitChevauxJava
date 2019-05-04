package mesClasses;

import java.util.ArrayList;

/**
 * Classe Case
 * @author Thomas Lapierre
 */

public abstract class Case {


	public Case() {
		
	}
	
	public ArrayList<Pion> getChevaux(){
		
		return null;
	}
	
	public void ajouteCheval(Pion pion) {
		
	}

	public abstract boolean peutPasser(Pion pion);
	
	public abstract boolean peutSArreter(Pion pion);

}