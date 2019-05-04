package mesClasses;
/**
 * Classe pour les cases principales. Cette classe hérite de Case.
 * @author thomaslapierre
 *
 */
public class CaseDeChemin extends Case {
	
	public CaseDeChemin() {
		
	}

	@Override
	public boolean peutPasser(Pion pion) {
		return false;
	}

	@Override
	public boolean peutSArreter(Pion pion) {
		return false;
	}

}
