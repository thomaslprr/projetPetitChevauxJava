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
	
	public Pion(String nom, Couleur couleur) {
		id=nom;
		this.couleur= couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}
}
