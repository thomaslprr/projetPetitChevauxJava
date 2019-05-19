package mesClasses;

import mesEnum.Couleur;
import mesExceptions.ConflitDeCouleurException;

/**
 *  Classe Case Colorée 
 * @author thomaslapierre
 * Cette classe hérite de Case
 */
public abstract class CaseColoree extends Case {
	private Couleur couleur;
	
	
	public CaseColoree(Couleur couleur) throws ConflitDeCouleurException {
		this.couleur=couleur;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}

}
