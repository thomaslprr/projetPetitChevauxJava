package mesClasses;

import mesEnum.Couleur;

/**
 * Classe Pion 
 * @author Thomas Lapierre
 *
 */
public class Pion {
	
	private String id;
	private Couleur couleur;
	private Case positionPion;
	private Joueur j;
	
	public Pion(String id, Couleur couleur) {
		this.id=id;
		this.couleur= couleur;
		this.positionPion=j.getCaseDeDepart();
	}

	public Couleur getCouleur() {
		return couleur;
	}
}
