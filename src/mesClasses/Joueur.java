package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;
/**
 * Classe Joueur
 * @author Thomas Lapierre
 *
 */
public abstract class Joueur {
	/**
	 * Déclaration des attributs
	 */
	private String nomJoueur;
	private Case caseJoueurDepart;
	private Couleur couleurJoueur;
	private ArrayList<Pion> pions = new ArrayList<Pion>();
	
	
	/**
	 * Constructeur d'un joueur
	 * @param nom Prend en paramètre un nom qui lui sera attribué
	 * @param cou Couleur qu'aura le joueur tout au long de sa partie.
	 * Lorsque l'on instancie un joueur, on lui créé et ajoute par la même occasion ses quatres pions.
	 */
	public Joueur(String nom, Couleur cou) {
		nomJoueur=nom;
		couleurJoueur=cou;
		this.ajouterPion(new Pion("1",cou));
		this.ajouterPion(new Pion("2",cou));
		this.ajouterPion(new Pion("3",cou));
		this.ajouterPion(new Pion("4",cou));
	}
	
	/**
	 * Permet de récupérer la couleur d'un joueur.
	 * @return Couleur du joueur 
	 */
	public Couleur getCouleur() {
		return couleurJoueur;
	}

	/**
	 * Permet de récupérer le nom du joueur
	 * @return le nom du joueur
	 */
	public String getNom() {
		return nomJoueur;
	}
	
	/**
	 * Permet de changer le nom du joueur, en cours de partie par exemple. (pas utilisée mais peut servir)
	 * @param nomJoueur nouveau nom du joueur
	 */
	public void setNom(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	/**
	 * Permet de savoir la case de départ où commence chaque pion du joueur.
	 * @return case de départ du joueur
	 */
	public Case getCaseDeDepart() {
		return caseJoueurDepart;
	}

	/**
	 * Permet de changer la case de départ d'un joueur.
	 * @param caseJoueur nouvelle case joueur
	 */
	public void setCaseDeDepart(Case caseJoueur) {
		this.caseJoueurDepart = caseJoueur;
	}

	/**
	 * 
	 * @return Retourne les pions du joueur (Ils sont au nombre de 4.)
	 */
	public ArrayList<Pion> getPions() {
		return pions;
	}
	
	/**
	 * Permet d'ajouter un pion à un joueur.
	 * @param pion pion à ajouter 
	 */
	public void ajouterPion(Pion pion) {
		pions.add(pion);
	}
	
	/**
	 * Propose toutes les possibilités de jeu que s'offre à un joueur. 
	 * Le joueur choisit ainsi le choix qu'il souhaite 
	 * Plusieurs propositions peuvent être proposées au joueur comme aucune ou comme seulement une.
	 * @param num La valeur du dé
	 * @param pla Le plateau de jeu
	 * @return Le pion que le joueur a choisi.
	 */
	public abstract Pion choisirPion(int num, Plateau pla);
	
	
	
}
