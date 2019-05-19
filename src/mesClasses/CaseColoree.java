package mesClasses;

import mesEnum.Couleur;
import mesExceptions.ConflitDeCouleurException;

/**
 *  Classe Case Colorée 
 * @author Thomas Lapierre
 * Cette classe hérite de Case
 */
public abstract class CaseColoree extends Case {
	/**
	 * Ajout d'une couleur.
	 */
	private Couleur couleur; 
	
	
	public CaseColoree(Couleur couleur) throws ConflitDeCouleurException {
		this.couleur=couleur;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}

}
