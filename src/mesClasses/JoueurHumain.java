package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;

/**
 * Classe pour les joueurs humains. 
 * Cette classe est faite pour les joueurs qui ne sont pas des bots.
 * @author Thomas Lapierre
 *
 */
public class JoueurHumain extends Joueur {

	/**
	 * Constructeur d'un joueur humain
	 * @param nom Nom du joueur
	 * @param cou Couleur du joueur
	 */
	public JoueurHumain(String nom, Couleur cou) {
		super(nom,cou);
	}
	
	/**
	 * Fonction rajoutée pour simplifier la récupération d'une position d'un pion
	 * Il suffit seulement de lui passer le pion et le plateau en paramètre et cette fonction nous renvoie sa position.
	 * Facultatif mais utile.  
	 * @param pla Plateau de jeu
	 * @param pion Pion où on souhaite connaître sa position.
	 * @return la position sous forme d'entier
	 */
	public int savoirPosition(Plateau pla, Pion pion) {
		for(CaseDeChemin cdc : pla.getChemin()) {
			for(Pion pi : cdc.getChevaux()) {
				if(pion==pi) {
					return cdc.getNumeroCaseChemin()+1;
				}				
			}			
		}
		return 0;		
	}
	
	/**
	 * Fonction permettant de connaître la position d'un cheval sur l'échelle. 
	 * Elle sert à connaître l'indice d'échelle d'un pion.
	 * @param pla Plateau de jeu 
	 * @param pion Pion où on souhaite connaître sa position d'échelle
	 * @return Position du pion (int) 
	 */
	public int savoirPositionEchelle(Plateau pla, Pion pion) {
		for(ArrayList<CaseDEchelle> listeE : pla.getEchelles()) {
			for(CaseDEchelle cde : listeE ) {
				for(Pion pi : cde.getChevaux())
					if(pion==pi) {
						return cde.getNumeroCaseEchelle();
					}				
			}			
		}
		return 0;		
	}
		
	/**
	 * Méthode rajoutée mais très utile qui permet de savoir si le pion d'un joueur va dépasser le tour. 
	 * Si c'est le cas la fonction renvoie true sinon false. Elle préviendra la fonction choisir pion qui ne proposera ainsi pas au joueur de choisir ce pion s'il voit qu'il dépassera le tour.
	 * @param pi Pion du joueur
	 * @param de Résultat du dé 
	 * @param pla Plateau de jeu 
	 * @return true OU false 
	 * true si le pion dépasse le tour s'il joue, false s'il ne dépasse pas le tour.
	 */
	public boolean depasseTour(Pion pi, int de, Plateau pla) {
		
		int numFuturCase;
		for(CaseDeChemin cdc : pla.getChemin()) {
			for(Pion pio : cdc.getChevaux()) {
				if(pi==pio) {
						numFuturCase = pla.getChemin().indexOf(cdc)+de;
						
						if(pi.getCouleur()==Couleur.BLEU ) {
							if(numFuturCase>55 && pla.getChemin().indexOf(cdc)<=55) { //si avant de jouer il est sur la case 55 ou moins et qu'après jouer il se trouve après 55.
								return true;
							}else {
								return false;
							}
						}else if (pi.getCouleur()==Couleur.VERT ) {
							if(numFuturCase>27 && pla.getChemin().indexOf(cdc)<=27) { //si avant de jouer il est sur la case 27 ou moins et qu'après jouer il se trouve après 27.

								return true;
							}else {
								return false;
							}
						}else if(pi.getCouleur()==Couleur.JAUNE ) {
							if(numFuturCase>41 && pla.getChemin().indexOf(cdc)<=41) { //si avant de jouer il est sur la case 41 ou moins et qu'après jouer il se trouve après 41.

								return true;
							}else {
								return false;
							}
						}else if(pi.getCouleur()==Couleur.ROUGE ) {
							if(numFuturCase>13 && pla.getChemin().indexOf(cdc)<=13) { //si avant de jouer il est sur la case 13 ou moins et qu'après jouer il se trouve après 13.

								return true;
							}else {
								return false;
							}
						}
				}
	
			}
		}
		return false;
	}
	/**
	 * Méthode rajoutée qui permet de savoir quand un pion peut monter dans l'échelle 
	 * A chaque tour la méthode choisirPion vérifiera si un pion peut monter dans l'échelle ou non. 
	 * Un pion peut monter s'il est à l'entrée (au pied) de l'échelle et que le dé est de 1.
	 * @param pi Un pion 
	 * @param de Résultat du dé 
	 * @param pla Plateau de jeu 
	 * @return - True si le pion peut monter dans l'échelle - False si le pion ne peut pas monter dans l'échelle
	 * 
	 */
	public boolean peutMonterEchelle(Pion pi, int de, Plateau pla) {
		for(CaseDeChemin cdc : pla.getChemin()) {
			for(Pion pio : cdc.getChevaux()) {
				if(pi==pio) {						
						if(pi.getCouleur()==Couleur.BLEU ) {
							if(pla.getChemin().indexOf(cdc)==55 && de==1) { //on regarde si le pion est à l'entrée de son échelle et si le dé est de 1.
								return true;
							}else {
								return false;
							}
						}else if (pi.getCouleur()==Couleur.VERT ) {
							if(pla.getChemin().indexOf(cdc)==27 && de==1) {

								return true;
							}else {
								return false;
							}
						}else if(pi.getCouleur()==Couleur.JAUNE ) {
							if(pla.getChemin().indexOf(cdc)==41 && de==1) {

								return true;
							}else {
								return false;
							}
						}else if(pi.getCouleur()==Couleur.ROUGE ) {
							if(pla.getChemin().indexOf(cdc)==13 && de==1) {

								return true;
							}else {
								return false;
							}
						}
				}
			}
		}
		return false;	
		
	}
	
	@Override
	public Pion choisirPion(int de, Plateau pla) {

		ArrayList<Pion> choixPossible = new ArrayList<Pion>();
		int choix=-1;
		
		for(Pion pi : this.getPions()) {
			
			
			for(CaseEcurie ce : pla.getEcuries()) {
				for(Pion pio : ce.getChevaux()) {
					if(pi==pio) {
						if(de==6) {
							choixPossible.add(pi);
						}
					}	
				}	
			}
			
			int numFuturCase;
			boolean erreurTrajet=false;
			for(CaseDeChemin cdc : pla.getChemin()) {
				for(Pion pio : cdc.getChevaux()) {
					if(pi==pio) {
						for(int i=1;i<de;i++) {
							numFuturCase = pla.getChemin().indexOf(cdc)+i;
							if(numFuturCase > 55) {
	                            numFuturCase -= 56;
	                        }
							if(pla.getChemin().get(numFuturCase).peutPasser(pi)==false) {
								erreurTrajet=true;
							}
						}
						numFuturCase = pla.getChemin().indexOf(cdc)+de;
						if(numFuturCase > 55) {
                            numFuturCase -= 56;
                        }
						if(pla.getChemin().get(numFuturCase).peutSArreter(pi)==false) {
							erreurTrajet=true;
						}
						if(depasseTour(pi,de,pla)) {
							erreurTrajet=true;
						}
						
						if(peutMonterEchelle(pi,de,pla)) {
							choixPossible.add(pi);
						}
						
						if (erreurTrajet==false){ 
							choixPossible.add(pi);
						}
						
					}
				}
			}
			
			
			
			int caseApres;
			for(ArrayList<CaseDEchelle> listeechelle : pla.getEchelles()) {
				for(CaseDEchelle cde : listeechelle) {
					caseApres = listeechelle.indexOf(cde)+1;
					for(Pion pio : cde.getChevaux()) {
						if(pi==pio) {
							if(savoirPositionEchelle(pla,pi)+1==de && listeechelle.get(caseApres).peutSArreter(pi) && de<6){
								choixPossible.add(pi);
							}else if(savoirPositionEchelle(pla,pi)+1==de && de==6) {
								choixPossible.add(pi);
							}
						}
					}	
				}
			}
			
			
			
			
			
		}
		
		
		
		
		
		
	
		
		
		
		if(choixPossible.size()>0) {
			do {
				System.out.println("Quel pion voulez-vous déplacer parmis les suivants ?");
				for(int i=0;i<choixPossible.size();i++) {
					System.out.println(i+" : "+"Pion "+choixPossible.get(i).getId());
				}
				try {	
					choix=Partie.sc.nextInt();
				}catch(java.util.InputMismatchException e) {
					System.out.println("Veuillez saisir un chiffre parmis ceux proposé(s). Tout autre saisie ne pourra fonctionner. ");
					Partie.sc.nextLine();
					choix=-1;
				}
			}while(choix<0 || choix>=choixPossible.size());
			return choixPossible.get(choix);
		}else {
			return null;
		}
	

	
	}
}
