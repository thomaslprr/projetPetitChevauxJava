package mesClasses;

import mesEnum.Couleur;

/**
 *  Classe Case Colorée 
 * @author thomaslapierre
 * Cette classe hérite de Case
 */
public abstract class CaseColoree extends Case {

	private Couleur couleur;
	
	public CaseColoree(Couleur couleur) {
		this.couleur=couleur;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}

}
