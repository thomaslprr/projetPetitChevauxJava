package mesClasses;

import java.util.ArrayList;

public class Joueur {
	
	private String nomJoueur;
	private Case caseJoueur;
	private Couleur couleurJoueur;
	
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
		
		return null;
	}
	
	public Pion choisirPion(int num, Plateau pla) {
		
		return Pion;
	}
	
	
	
}
