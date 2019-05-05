package mesClasses;
/**
 * Classe pour les cases principales. Cette classe hérite de Case.
 * @author thomaslapierre
 *
 */
public class CaseDeChemin extends Case {
	private static int compteurCaseChemin = 1 ;
	private int numeroCase ; 
	
	public CaseDeChemin() {
		numeroCase=compteurCaseChemin;
		compteurCaseChemin++;
	}
	
	public int getNumeroCaseChemin() {
		return numeroCase;
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
