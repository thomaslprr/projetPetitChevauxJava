package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;
/**
 * Classe Joueur
 * @author Thomas Lapierre
 *
 */
public abstract class Joueur {
	
	private String nomJoueur;
	private Case caseJoueur;
	private Couleur couleurJoueur;
	private ArrayList<Pion> chevaux;
	
	public Joueur() {
		nomJoueur=null;
		couleurJoueur= null;
		caseJoueur=null;
	}
	
	public Joueur(String nom, Couleur cou) {
		nomJoueur=nom;
		couleurJoueur=cou;
	}

	public Couleur getCouleur() {
		return couleurJoueur;
	}


	public String getNom() {
		return nomJoueur;
	}

	public void setNom(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public Case getCaseDeDepart() {
		return caseJoueur;
	}

	public void setCaseDeDepart(Case caseJoueur) {
		this.caseJoueur = caseJoueur;
	}

	public ArrayList<Pion> getChevaux() {
		return chevaux;
	}
	
	public abstract Pion choisirPion(int num, Plateau pla);
	
	
	
}
