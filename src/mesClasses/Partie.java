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
	public static final Scanner sc = new Scanner(System.in);
	
	public Partie() throws PasDeJoueursException  {
		int reponse=-1;
		System.out.println("||||| Bienvenue sur le jeu des petits chevaux |||||");
		System.out.println("Vous venez de lancer une partie, bonne partie.");
		
		
		
		initialiserJoueurs(4);
		
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
			
			for(Joueur jh : joueurs) {
				System.out.println(jh.getNom() + " a pour couleur "+ jh.getCouleur().getNom());
			}
			
		
		}
		
		this.joueurCommence();
        System.out.println(joueurCourant.getCouleur().getCode()+joueurCourant.getNom()+" commence à jouer !\033[0m");
		
		
	}
	
	
	public void joueurCommence() {
		int nbreAleatoire = (int)(Math.random() * ((3) + 1));
		this.joueurCourant=joueurs.get(nbreAleatoire);
	}
	
	
	
	public void initialiserPlateau() {
		p = new Plateau();
		for(int i=0;i<joueurs.size();i++) {
			for(Pion pio: joueurs.get(i).getPions()) {
				p.getEcuries().get(i).ajouteCheval(pio);
				
			}
			joueurs.get(i).setCaseDeDepart(p.getChemin().get(0+joueurs.indexOf(joueurs.get(i))*14));
		}
		for(Joueur j : joueurs) {
			switch (j.getCouleur()) {
			case JAUNE:
				j.setCaseDeDepart(p.getChemin().get(42));
				break;
			case VERT:
				j.setCaseDeDepart(p.getChemin().get(28));
				break;
			case BLEU:
				j.setCaseDeDepart(p.getChemin().get(0));
				break;
			case ROUGE:
				j.setCaseDeDepart(p.getChemin().get(14));
				break;
			default:
				break;
			}
		}
		
	}
	
	public int lanceDe() {
		return de.nextInt(6) + 1;
	}
	
	public void jouerUnTour() {
		int resultatDe = lanceDe();
		System.out.println("Résultat du dé : "+ resultatDe);
		sc.nextLine();
		Pion pionABouger = joueurCourant.choisirPion(resultatDe, p);
		
		Case caseArrivé = null;
		
		
		if(pionABouger != null ) {
			
				
				for(Case cases : p.getEcuries()) {
	                if(cases.getChevaux().indexOf(pionABouger) != -1)
	                    caseArrivé = joueurCourant.getCaseDeDepart();
	            }
				
				for(Case cases : p.getChemin()) {
	                if(cases.getChevaux().indexOf(pionABouger) != -1) {
	                	if(p.getChemin().indexOf(cases)+resultatDe<=55) {
	                		caseArrivé = p.getChemin().get(p.getChemin().indexOf(cases)+resultatDe);
	                	}else {
	                		caseArrivé = p.getChemin().get((p.getChemin().indexOf(cases)+resultatDe)-56);
	                	}
	                	mangerLesPions(caseArrivé);
	                }
	                    
	            }
				
				for(ArrayList<CaseDEchelle> le : p.getEchelles()) {
					for(CaseDEchelle cec : le) {
						if(cec.getChevaux().indexOf(pionABouger) != -1) {
							caseArrivé= le.get(cec.getChevaux().indexOf(pionABouger)+1);
						}
					}
				}
				
				
				
				
				p.deplacerPionA(pionABouger, caseArrivé);
				
				
				p.afficher();
				
				
				
				
				
			}else {
				System.out.println("Vous ne pouvez pas déplacer de pion.");
			}
		
		
		
		
		
		
		
		
		sc.nextLine();
		
		setJoueurCourrant(joueurCourant);
		System.out.println("C'est au tour de "+ joueurCourant.getCouleur().getCode()+joueurCourant.getNom()+"\033[0m de jouer");
		sc.nextLine();
	}
	
	public boolean estPartieTermine() {
		
		for(ArrayList<CaseDEchelle> echelle : p.getEchelles())	{
			
			boolean ok = true;
			
				for(int i=2;i<6; i++) {
					
					if(echelle.get(i).getChevaux().size()!=1) {
						
						ok=false;
					}
					
				}	
				
			if(ok==true) {
				return true;
			}
				
		}
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
				}
			}
		}
		c.getChevaux().clear();
		
	
	}
}
