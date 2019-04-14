package mesClasses;

public class Joueur {
	
	private String nomJoueur;
	private Case caseJoueur;
	private Couleur couleurJoueur;
	
	public Joueur(String nom, Couleur cou) {
		
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

	
	
	
	
}
