package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;
import mesExceptions.CasePleineException;
/**
 * Classe Joueur
 * @author Thomas Lapierre
 *
 */
public abstract class Joueur {
	
	private String nomJoueur;
	private Case caseJoueurDepart;
	private Couleur couleurJoueur;
	private ArrayList<Pion> pions = new ArrayList<Pion>();
	
	public Joueur(String nom, Couleur cou) {
		nomJoueur=nom;
		couleurJoueur=cou;
		this.ajouterPion(new Pion("1",cou));
		this.ajouterPion(new Pion("2",cou));
		this.ajouterPion(new Pion("3",cou));
		this.ajouterPion(new Pion("4",cou));
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
		return caseJoueurDepart;
	}

	public void setCaseDeDepart(Case caseJoueur) {
		this.caseJoueurDepart = caseJoueur;
	}

	public ArrayList<Pion> getPions() {
		return pions;
	}
	
	public void ajouterPion(Pion pion) {
		pions.add(pion);
	}
	
	
	public abstract Pion choisirPion(int num, Plateau pla);
	
	
	
}
