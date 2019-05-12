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
	private Joueur joueurCourant ;
	
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
		
		p.afficher();
		
		joueurCourant = joueurs.get(2);
		
		p.deplacerPionA(joueurCourant.getPions().get(2), p.getChemin().get(12));
		p.deplacerPionA(joueurCourant.getPions().get(1), p.getChemin().get(12));
		System.out.println(p.getChemin().get(12).getChevaux().size());
		System.out.println(p.getChemin().get(13).getChevaux().size());
		
		
		p.afficher();
	}
	
	public void initialiserJoueurs(int nbreJoueur) throws PasDeJoueursException {
		if(nbreJoueur == 0) {
			throw new PasDeJoueursException();
		}else {
			
		
			Scanner sc = new Scanner(System.in);
			String nomChoisi;
			Couleur couleurChoisi;
			ArrayList<Couleur> couleursDisponible = new ArrayList<Couleur>();
			couleursDisponible.add(Couleur.JAUNE);
			couleursDisponible.add(Couleur.BLEU);
			couleursDisponible.add(Couleur.ROUGE);
			couleursDisponible.add(Couleur.VERT);
			 
				
			for(int j=0;j<nbreJoueur;j++) {
				System.out.println("Quel est le prénom du joueur "+(j+1)+" pour la couleur "+ couleursDisponible.get(0));
				nomChoisi = sc.nextLine();
				
				
				
				couleurChoisi = couleursDisponible.get(0);
				couleursDisponible.remove(0);
				
					
				joueurs.add(new JoueurHumain(nomChoisi ,couleurChoisi));
				
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
		for(int i=0;i<joueurs.size();i++) {
			for(Pion pio: joueurs.get(i).getPions()) {
				p.getEcuries().get(i).ajouteCheval(pio);
			}
		}
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
