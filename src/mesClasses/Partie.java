package mesClasses;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import mesEnum.Couleur;
import mesExceptions.PasDeJoueursException;

public class Partie  {
	private int de;
	private ArrayList<JoueurHumain> joueurs = new ArrayList<JoueurHumain>();
	private Plateau p;
	private Joueur joueurCourant;
	
	public Partie() throws PasDeJoueursException  {
		Scanner sc = new Scanner(System.in);
		int reponse=-1;
		System.out.println("||||| Bienvenue sur le jeu des petits chevaux |||||");
		System.out.println("Vous venez de lancer une partie, bonne partie.");
		
		while(reponse <= 0 || reponse > 4) {
			System.out.println("Combien voulez-vous de joueur(s) ?");
			try {
				reponse = sc.nextInt();
			}catch (InputMismatchException exception) { 
			    System.out.println("Mauvaise entrée");
			    sc.next();
			    reponse = -1;
			}
		}
		
		initialiserJoueurs(reponse);
		
		initialiserPlateau();
	}
	
	public void initialiserJoueurs(int nbreJoueur) throws PasDeJoueursException {
		if(nbreJoueur == 0) {
			throw new PasDeJoueursException();
		}else {
			
		
			Scanner sc = new Scanner(System.in);
			String nomChoisi;
			Couleur couleurChoisi;
			ArrayList<Couleur> couleursDisponible = new ArrayList<Couleur>();
			couleursDisponible.add(Couleur.BLEU);
			couleursDisponible.add(Couleur.JAUNE);
			couleursDisponible.add(Couleur.ROUGE);
			couleursDisponible.add(Couleur.VERT);
			
			for(int i = 0; i < nbreJoueur; i++) {  
				
				
				System.out.println("Quel est le prénom du joueur "+(i+1));
				nomChoisi = sc.nextLine();
				
				
				int rep=-10;
				
				while(rep < 0 || rep >= couleursDisponible.size()) { 
					
					System.out.println("Choissisez une des couleurs suivantes : ");
					for(int j = 0; j < couleursDisponible.size(); j++) {
						System.out.println(j+"]  "+couleursDisponible.get(j));
					}
					
					
					try {
						rep = sc.nextInt();
					}catch (InputMismatchException exception) { 
					    System.out.println("Mauvaise entrée");
					    sc.next();
					    rep = -1;
					}
				}
				
				couleurChoisi = couleursDisponible.get(rep);
				couleursDisponible.remove(rep);
				
					
				joueurs.add(new JoueurHumain(nomChoisi ,couleurChoisi));
				
				sc.nextLine();
			}
			
			sc.close();
			for(Joueur jh : joueurs) {
				System.out.println(jh.getNom() + " a pour couleur "+ jh.getCouleur().getNom());
			}
			
		
		}
		
		
		
		
	}
	
	
	public void joueurCommence() {
		int nbreAleatoire = 1 + (int)(Math.random() * ((4 - 1) + 1));	
		this.joueurCourant=joueurs.get(nbreAleatoire);
		System.out.println("Le joueur "+ joueurCourant+" commence à lancer le dé.");
	}
	
	
	public void initialiserPlateau() {
		p = new Plateau();
	}
	
	public int lanceDe() {
		this.de = 1 + (int)(Math.random() * ((6 - 1) + 1));
		return de;
	}
	
	public void jouerUnTour() {
		
	}
	
	public boolean estPartieTermine() {
		return false;
		
		
	}
	
	public Joueur getJoueurCourrant() {
		
		return joueurCourant;
	}
	
	public void setJoueurCourrant(Joueur j) {
		this.joueurCourant = j;
	}
	
	public Plateau getPlateau() {
		return p;
	}
	
	public ArrayList<JoueurHumain> getJoueur(){
		return joueurs;
	}
	
	public void mangerLesPions(Case c) {
		for(Pion pi : c.getChevaux()) {
			for(CaseEcurie ce : p.getEcuries()) {
				if(pi.getCouleur()==ce.getCouleur()) {
					ce.ajouteCheval(pi);
					ce.retirerCheval(pi);
				}
			}
		}
	
	}
}
