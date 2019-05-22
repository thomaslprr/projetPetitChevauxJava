package mesClasses;

import java.util.ArrayList;

/**
 * Classe Case
 * @author Thomas Lapierre
 */


public abstract class Case {
	/**
	 * Déclaration des attributs : 
	 * - Une liste de pion (ceux qui sont sur la case) 
	 */
	private ArrayList<Pion> pionCase = new ArrayList<Pion>();
	private static int nombreCaseTotale = 0;
	
	/**
	 * Constructeur d'une case
	 * on s'assure qu'elle ne possède aucun pion avant.
	 */
	public Case() {
		nombreCaseTotale++;
		pionCase.clear();
	}
	
	/**
	 * Permet de retourner tous les pions étant sur cette case
	 * @return pionCase Retourne les chevaux sur cette case.
	 * Fonction très utilisée tout au long du jeu
	 */
	public ArrayList<Pion> getChevaux(){
		
		return pionCase;
	}
	
	/**
	 * Permet d'ajouter un pion sur une case
	 * @param pion pion 
	 */
	public void ajouteCheval(Pion pion) {
		pionCase.add(pion);
	}
	
	/**
	 * Permet de retirer un pion d'une case
	 * @param pion pion 
	 */
	public void retirerCheval(Pion pion) {
		pionCase.remove(pion);
	}

	/**
	 * Cette méthode sert à connaître le nombre total de case
	 * Elle ne sert pas dans le jeu mais pourra servir ultérieurement.
	 * @return Cette méthode retourne le nombre total de cases
	 */
	public int getCaseTotale() {
		return nombreCaseTotale;
	}
	
	/**
	 * Permet de déterminer si un pion peut passer sur cette case ou non.
	 * @param pion Elle prend en paramètre un pion pour savoir si ce pion peut passer sur cette case.
	 * @return true OU false 
	 * En fonction que la case soit une case de chemin ou d'échelle ou d'écurie les règles qui s'y appliquent sont différentes.
	 */
	public abstract boolean peutPasser(Pion pion);
	
	
	/**
	 * Permet de déterminer si un pion passer en paramètre peut s'arrêter sur cette case ou non.
	 * @param pion pion
	 * @return true OU false
	 */
	public abstract boolean peutSArreter(Pion pion);

}