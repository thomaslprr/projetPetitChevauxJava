package mesClasses;
/**
 * Classe pour les cases principales. Cette classe hérite de Case.
 * @author Thomas Lapierre
 *
 */
public class CaseDeChemin extends Case {
	private static int compteurCaseChemin = 0 ;
	private int numeroCase ; 
	/**
	 * Constructeur d'une case de chemin
	 */
	public CaseDeChemin() {
		numeroCase=compteurCaseChemin;
		compteurCaseChemin++;
	}
	/**
	 * 
	 * @return le numéro de la case de chemin 
	 */
	public int getNumeroCaseChemin() {
		return numeroCase;
	}
	
	/**
	 * Un pion peut passer sur une case de chemin si le ou les pions qui se trouvent sur cette case sont de la même couleur. 
	 * Sinon, le pion ne peut passer. 
	 */
	@Override
	public boolean peutPasser(Pion pion) {
		for(Pion p : this.getChevaux()) {
			if(p.getCouleur() != pion.getCouleur()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Un pion peut toujours s'arrêter sur une case de chemin.
	 * S'il s'agit d'un pion de couleur différente ce pion sera mangé par la suite. 
	 * Sinon plusieurs pions d'une même couleur peuvent être sur une même case.
	 */
	@Override
	public boolean peutSArreter(Pion pion) {
		return true;
	}

}
	