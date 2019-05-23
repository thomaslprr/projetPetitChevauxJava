package mesClasses;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import mesEnum.Couleur;
import mesExceptions.CasePleineException;
import mesExceptions.PasDeJoueursException;

/**
 * 
 * @author Thomas Lapierre et Benjamin Picot
 *
 */

public class Partie  {
	private Random de= new Random();
	private ArrayList<JoueurHumain> joueurs = new ArrayList<JoueurHumain>();
	private Plateau p;
	private Joueur joueurCourant ;
	public static final Scanner sc = new Scanner(System.in);
	 /**
	  * Création d'une partie 
	  * On initialise les 4 joueurs 
	  * On initialise le plateau 
	  * @throws PasDeJoueursException exception si pas de joueur à initialiser
	  */
	public Partie() throws PasDeJoueursException  {
		System.out.println("||||| Bienvenue sur le jeu des petits chevaux |||||");
		System.out.println("Vous venez de lancer une partie, bonne partie.");
		
		
		
		initialiserJoueurs(4);
		
		initialiserPlateau();		
	}
	
	/**
	 * Méthode permettant d'initialiser les joueurs 
	 * @param nbreJoueur Nombre de joueur à initialiser
	 * @throws PasDeJoueursException exception quand pas de joueur
	 */
	public void initialiserJoueurs(int nbreJoueur) throws PasDeJoueursException {
		if(nbreJoueur == 0) {
			throw new PasDeJoueursException();
		}else {
			
		
			Scanner sc = new Scanner(System.in);
			String nomChoisi;
			Couleur couleurChoisi;
			ArrayList<Couleur> couleursDisponible = new ArrayList<Couleur>();
			/**
			 * on propose les 4 couleurs possibles
			 */
			couleursDisponible.add(Couleur.JAUNE);
			couleursDisponible.add(Couleur.BLEU);
			couleursDisponible.add(Couleur.ROUGE);
			couleursDisponible.add(Couleur.VERT);
			 
			/**
			 * Pour chaque joueur, l'utilisateur sélectionne un nom qui sera attribué à une couleur
			 */
			for(int j=0;j<nbreJoueur;j++) {
				System.out.println("Quel est le prénom du joueur "+(j+1)+" pour la couleur "+ couleursDisponible.get(0));
				nomChoisi = sc.nextLine();
				
				
				
				couleurChoisi = couleursDisponible.get(0);
				couleursDisponible.remove(0);
				
					
				joueurs.add(new JoueurHumain(nomChoisi ,couleurChoisi));
				
			}
			/**
			 * Récapitulatif de la couleur que possède chaque joueur
			 */
			for(Joueur jh : joueurs) {
				System.out.println(jh.getNom() + " a pour couleur "+ jh.getCouleur().getNom());
			}
			
		
		}
		/**
		 * Indication de quel joueur commence
		 */
		this.joueurCommence();
        System.out.println(joueurCourant.getCouleur().getCode()+joueurCourant.getNom()+" commence à jouer !\033[0m");
		
		
	}
	
	/**
	 * Méthode permettant de déterminer aléatoirement quel joueur commence
	 */
	public void joueurCommence() {
		int nbreAleatoire = (int)(Math.random() * ((3) + 1));
		this.joueurCourant=joueurs.get(nbreAleatoire);
	}
	
	
	/**
	 * Méthode permettant d'initialiser le plateau 
	 * On créé d'abord le plateau, ensuite on attribut la case de départ que chaque joueur aura. 
	 * 
	 */
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
				j.setCaseDeDepart(p.getChemin().get(28)); //les pions du joueurs vert seront à la case 28 lorsqu'ils sortiront de l'écurie
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
	
	/**
	 * Permet de simuler un lancer de dé 
	 * @return Un nombre aléatoire compris entre 1 et 6.
	 */
	public int lanceDe() {
		return de.nextInt(6) + 1;
	}
	
	/**
	 * Méthode qui permet de jouer un tour 
	 * Elle lance le dé, annonce le joueur qui doit jouer, fait rejouer si la personne fait un 6 
	 * Cette méthode déplace le pion choisi. C'est comme le main d'un tour d'une partie.
	 */
	public void jouerUnTour() {
		
		int cpt=0;
		int resultatDe=0;
		do {
			resultatDe = lanceDe();
			System.out.println("Résultat du dé : "+ resultatDe);
			sc.nextLine();
			/**
			 * Va exécuter la méthode choisirPion 
			 */
			Pion pionABouger = joueurCourant.choisirPion(resultatDe, p);
			
			Case caseArrivé = null;
			
			/**
			 * le but de cette fonction va être de chercher la case d'arrivé pour ainsi déplacer le pion choisi sur cette case d'arrivé
			 * on ne s'occupe pas ici de savoir si c'est possible ou non, on le fait juste.
			 */
			if(pionABouger != null ) {
				
					/**
					 * On parcourt les cases d'écurie
					 */
					for(Case cases : p.getEcuries()) {
		                if(cases.getChevaux().indexOf(pionABouger) != -1) {
		                	/**
		                	 * la case d'arrivé est égale à la case de départ du pion défini auparavant
		                	 */
		                    caseArrivé = joueurCourant.getCaseDeDepart();
		                    /**
		                     * si la case d'arrivé contient des pions qui ne sont pas de la couleur du pion qui sort, il les mange
		                     */
		                    if(caseArrivé.getChevaux().size()>0 && caseArrivé.getChevaux().get(0).getCouleur()!=joueurCourant.getCouleur()) {
			                	mangerLesPions(caseArrivé);
		                    }
		                }
		            }
					/**
					 * On parcourt les cases de chemin 
					 */
					for(Case cases : p.getChemin()) {
		                if(cases.getChevaux().indexOf(pionABouger) != -1) {
		                	/**
		                	 * si le pion est sur une case d'entrée d'échelle, sa case d'arrivée est la première case de son échelle
		                	 */
		                	if(p.getChemin().indexOf(cases)==55 && pionABouger.getCouleur()==Couleur.BLEU) {
		                		caseArrivé= p.getEchelles().get(3).get(0);
		                	}else if(p.getChemin().indexOf(cases)==27 && pionABouger.getCouleur()==Couleur.VERT) {
		                		caseArrivé= p.getEchelles().get(2).get(0);
		                	}else if(p.getChemin().indexOf(cases)==41 && pionABouger.getCouleur()==Couleur.JAUNE) {
		                		caseArrivé= p.getEchelles().get(0).get(0);
		                	}else if(p.getChemin().indexOf(cases)==13 && pionABouger.getCouleur()==Couleur.ROUGE) {
		                		caseArrivé= p.getEchelles().get(1).get(0);
		                	}else if(p.getChemin().indexOf(cases)+resultatDe<=55) { 
		                		caseArrivé = p.getChemin().get(p.getChemin().indexOf(cases)+resultatDe); // la case d'arrivée est la case actuelle + le dé
		                	}else if (p.getChemin().indexOf(cases)+resultatDe>55) {
		                		caseArrivé = p.getChemin().get((p.getChemin().indexOf(cases)+resultatDe)-56); // si la case actuelle + le dé est plus grand que le tour d'un plateau, la case d'arrivé est égale à la case actuelle + le dé moins la taille d'un tour de plateau 
		                	}
		                	if(caseArrivé.getChevaux().size()>0 && caseArrivé.getChevaux().get(0).getCouleur()!=joueurCourant.getCouleur()) {
				                	mangerLesPions(caseArrivé); //on pense à manger les pions sur la case d'arrivée
			                }
		                }
		                    
		            }
					
					for(ArrayList<CaseDEchelle> le : p.getEchelles()) {
						for(CaseDEchelle cec : le) {
							if(cec.getChevaux().indexOf(pionABouger) != -1) {
								caseArrivé=le.get((cec.getNumeroCaseEchelle())); //on avance de 1 sur l'échelle
							}
						}
					}
					
					
					
					/**
					 * On essaye de déplacer le pion si une erreur se produit on affiche le message d'erreur mais le programme continue
					 */
					try {
						p.deplacerPionA(pionABouger, caseArrivé);  // déplacement du pion
					} catch (CasePleineException e) {
						System.out.println(e.getMessage());
					}
					
					/**
					 * On affiche le plateau
					 */
					p.afficher();
					
					cpt++;
					
					
					
				}else {
					System.out.println("Vous ne pouvez pas déplacer de pion.");
				}
			
			
			
		}while(resultatDe==6 && cpt<2);
		/**
		 * Boucle qui permet de faire jouer 2 fois l'utilisateur s'il fait un 6 
		 */
		
		
		
		sc.nextLine();
		/**
		 * On passe au joueur suivant
		 */
		if(this.estPartieTermine()!= true) {
			setJoueurCourrant(joueurCourant);
			System.out.println("C'est au tour de "+ joueurCourant.getCouleur().getCode()+joueurCourant.getNom()+"\033[0m de jouer");
		}
		
		sc.nextLine();

	}
	/**
	 * Cette fonction permet d'arrêter le programme quand le jeu est fini. 
	 * Celui-ci est terminé lorsque les 4 chevaux d'un joueur sont sur la grille d'échelle 
	 * @return true si un des quatre joueurs a terminé sinon false
	 */
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
	/**
	 * Connaître le joueur courrant
	 * @return Joueur actuel
	 */
	public Joueur getJoueurCourrant() {
		
		return joueurCourant;
	}
	/**
	 * Permet de changer de joueur courant 
	 * Le joueur courant est celui d'après dans l'ordre. 
	 * @param j Prend en paramètre le joueur actuel pour ainsi après un calcul changer le joueur courrant en celui d'apères.
	 */
	public void setJoueurCourrant(Joueur j) {
		int numJ = joueurs.indexOf(j);
		numJ = (numJ+1)%4;
		this.joueurCourant = joueurs.get(numJ);
	}
	
	/**
	 * 
	 * @return le plateau de la partie
	 */
	public Plateau getPlateau() {
		return p;
	}
	
	/**
	 * Permet de récupérer la liste des joueurs d'une partie
	 * @return Les joueurs de la partie
	 */
	public ArrayList<JoueurHumain> getJoueur(){
		return joueurs;
	}
	
	/**
	 * Fonction qui permet de manger un pion
	 * @param c Une case
	 */
	public void mangerLesPions(Case c) {
		for(Pion pi : c.getChevaux()) {
			for(CaseEcurie ce : p.getEcuries()) {
				if(pi.getCouleur()==ce.getCouleur()) {
					/**
					 * le cheval est ajouté à l'écurie
					 */
					ce.ajouteCheval(pi);
				}
			}
		}
		/**
		 * le cheval est supprimé de la case 
		 */
		c.getChevaux().clear();
		/**
		 * On indique aux joueurs qu'un pion a été mangé
		 */
		System.out.println("Un pion a été mangé.");
	
	}
}
