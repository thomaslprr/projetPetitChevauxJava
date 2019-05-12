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
	
	public Pion(String id, Couleur couleur) {
		this.id=id;
		this.couleur= couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}
	
}
