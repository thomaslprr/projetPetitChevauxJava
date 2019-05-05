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
	
	public Partie() throws PasDeJoueursException  {
		System.out.println("||||| Bienvenue sur le jeu des petits chevaux |||||");
		System.out.println("Vous venez de lancer une partie, bonne partie.");
		for(int i=1;i<=4;i++) {
			initialiserJoueurs(i);
		}
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
				
				
				System.out.println("Quel est le nom du joueur "+(i+1));
				nomChoisi = sc.nextLine();
				
				
				int rep=-10;
				
				while(rep < 0 || rep > couleursDisponible.size()) { 
					
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
			
			
		
		}
		
		
		
		
	}
	
	public void initialiserPlateau() {
		p = new Plateau();
	}
	
	public int lanceDe() {
		this.de = (int)(Math.random() * 5);
		return de;
	}
	
	public void jouerUnTour() {
		
	}
	
	public boolean estPartieTermine() {
		return false;
		
	}
	
	public Joueur getJoueurCourrant() {
		
		return null;
	}
	
	public void setJoueurCourrant(Joueur j) {
		
	}
	
	public Plateau getPlateau() {
		return p;
	}
	
	public ArrayList<JoueurHumain> getJoueur(){
		return joueurs;
	}
	
	public void mangerLesPions(Case c) {
		
	}
}
