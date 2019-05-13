package mesClasses;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import mesEnum.Couleur;
import mesExceptions.PasDeJoueursException;

public class Partie  {
	private Random de= new Random();
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
		
		joueurCourant = joueurs.get(1);
		
		p.deplacerPionA(joueurCourant.getPions().get(2), p.getChemin().get(12));
		p.deplacerPionA(joueurCourant.getPions().get(1), p.getChemin().get(13));
		
		joueurCourant = joueurs.get(2);
		p.deplacerPionA(joueurCourant.getPions().get(2), p.getChemin().get(46));
		p.deplacerPionA(joueurCourant.getPions().get(1), p.getChemin().get(34));
		
		joueurCourant = joueurs.get(3);
		p.deplacerPionA(joueurCourant.getPions().get(0), p.getChemin().get(14));
		
		
	
		
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
		int nbreAleatoire = 1 + (int)(Math.random() * ((3) + 1));	
		this.joueurCourant=joueurs.get(nbreAleatoire);
		System.out.println("Le joueur "+ joueurCourant+" commence à lancer le dé.");
	}
	
	
	
	public void initialiserPlateau() {
		p = new Plateau();
		for(int i=0;i<joueurs.size();i++) {
			for(Pion pio: joueurs.get(i).getPions()) {
				p.getEcuries().get(i).ajouteCheval(pio);
				
			}
			joueurs.get(i).setCaseDeDepart(p.getChemin().get(0+joueurs.indexOf(joueurs.get(i))*14));
		}
	}
	
	public int lanceDe() {
		return de.nextInt(6) + 1;
	}
	
	public void jouerUnTour() {
		
		int resultatDe = lanceDe();
		
		Pion pionABouger = joueurCourant.choisirPion(resultatDe, p);
		
		Case caseArrivé = null;
		
		if(pionABouger != null ) {
			
			if(resultatDe != 6) {
				
				for(Case cases : p.getEcuries()) {
	                if(cases.getChevaux().indexOf(pionABouger) != -1)
	                    caseArrivé = joueurCourant.getCaseDeDepart();
	            }
				
				for(Case cases : p.getChemin()) {
	                if(cases.getChevaux().indexOf(pionABouger) != -1)
	                    caseArrivé = p.getChemin().get(p.getChemin().indexOf(pionABouger)+resultatDe);
	            }
				
				for(ArrayList<CaseDEchelle> le : p.getEchelles()) {
					for(CaseDEchelle cec : le) {
						if(cec.getChevaux().indexOf(pionABouger) != -1) {
							caseArrivé= le.get(cec.getChevaux().indexOf(pionABouger)+1);
						}
					}
				}
				
				
				
				
				p.deplacerPionA(pionABouger, caseArrivé);
				
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		setJoueurCourrant(joueurCourant);
		
	}
	
	public boolean estPartieTermine() {
		return false;	
	}
	
	public Joueur getJoueurCourrant() {
		
		return joueurCourant;
	}
	
	public void setJoueurCourrant(Joueur j) {
		int numJ = joueurs.indexOf(j);
		numJ = (numJ+1)%4;
		this.joueurCourant = joueurs.get(numJ);
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
