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
	/**
	 * Constructeur d'un pion 
	 * @param id Identifiant du pion / son numéro 
	 * @param couleur Couleur du pion 
	 */
	public Pion(String id, Couleur couleur) {
		this.id=id;
		this.couleur= couleur;
	}

	/**
	 * 
	 * @return La couleur du pion 
	 */
	public Couleur getCouleur() {
		return couleur;
	}
	
	/**
	 * 
	 * @return L'identifiant du pion 
	 */
	public String getId() {
		return id;
	}
}
