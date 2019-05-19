package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;
import mesExceptions.CasePleineException;
import mesExceptions.ConflitDeCouleurException;

public class Plateau {
	/**
	 * Déclaration et création des différentes ArrayList
	 */
	private ArrayList<ArrayList<CaseDEchelle>> listeEchelles = new ArrayList<ArrayList<CaseDEchelle>>();
	private ArrayList<CaseDeChemin> caseChemin = new ArrayList<CaseDeChemin>();
	private ArrayList<CaseDEchelle> echelleRouge = new ArrayList<CaseDEchelle>();
	private ArrayList<CaseDEchelle> echelleJaune = new ArrayList<CaseDEchelle>();
	private ArrayList<CaseDEchelle> echelleBleu = new ArrayList<CaseDEchelle>();
	private ArrayList<CaseDEchelle> echelleVert = new ArrayList<CaseDEchelle>() ;
	private ArrayList<CaseEcurie> ecuries = new ArrayList<CaseEcurie>();
	
	/**
	 * Constructeur de la classe Plateau.
	 * Il permet de créer les 4 écuries,
	 * les 56 cases de chemins et les 4 échelles propre à chaque joueur.
	 */
	
	public Plateau() {
		
		/**
		 * Création des 56 cases de chemins
		 */
		 for(int i=0; i<56; i++) {
			 caseChemin.add(new CaseDeChemin());
         }
		 
		/**
		 * Création des 4 écuries que l'on ajoute à la liste des écuries
		 */
		try {
			ecuries.add(new CaseEcurie(Couleur.JAUNE));
			ecuries.add(new CaseEcurie(Couleur.ROUGE));
			ecuries.add(new CaseEcurie(Couleur.VERT));
			ecuries.add(new CaseEcurie(Couleur.BLEU));
		} catch (ConflitDeCouleurException e) {
			System.out.println(e.getMessage());
		}
		
		
		/**
		 * création des 6 cases d'échelles que l'on regroupe ensemble pour former une échelle d'une couleur spécifique
		 */
		
		for(int i=0;i<6;i++) {
			try {
				echelleRouge.add(new CaseDEchelle(Couleur.ROUGE));
			} catch (ConflitDeCouleurException e) {
				e.getMessage();
			}
		}
		
		
		for(int i=0;i<6;i++) {
			try {
				echelleJaune.add(new CaseDEchelle(Couleur.JAUNE));
			} catch (ConflitDeCouleurException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		for(int i=0;i<6;i++) {
			try {
				echelleBleu.add(new CaseDEchelle(Couleur.BLEU));
			} catch (ConflitDeCouleurException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		for(int i=0;i<6;i++) {
			try {
				echelleVert.add(new CaseDEchelle(Couleur.VERT));
			} catch (ConflitDeCouleurException e) {
				System.out.println(e.getMessage());
			}
		}
		
		/**
		 * ajout des 4 échelles de couleurs différentes dans une liste échelle
		 */
		listeEchelles.add(echelleBleu);
		listeEchelles.add(echelleVert);
		listeEchelles.add(echelleJaune);
		listeEchelles.add(echelleRouge);
		
		
		 
	}
	
	
	
	public ArrayList<ArrayList<CaseDEchelle>> getEchelles() {
		return listeEchelles;
	}

	public ArrayList<CaseEcurie> getEcuries(){
		return ecuries;
	}
	
	public ArrayList<CaseDeChemin> getChemin(){
		
		return caseChemin;
	}


	public void afficher() {
	
		int[][] plateauValeur = {
				{-1,-1,-1,-1,-1,-1,55,56,1,-2,-2,-2,-2,-2,-2},
				{-1,-1,-1,-1,-1,-1,54,90,2,-2,-2,-2,-2,-2,-2},
				{-1,-1,-1,-1,-1,-1,53,91,3,-2,-2,-2,-2,-2,-2},
				{-1,-1,-1,-1,-1,-1,52,92,4,-2,-2,-2,-2,-2,-2},
				{-1,-1,-1,-1,-1,-1,51,93,5,-2,-2,-2,-2,-2,-2},
				{-1,-1,-1,-1,-1,-1,50,94,6,-2,-2,-2,-2,-2,-2},
				{43,44,45,46,47,48,49,95,7,8,9,10,11,12,13},
				{42,75,76,77,78,79,80,1000,68,67,66,65,64,63,14},
				{41,40,39,38,37,36,35,74,21,20,19,18,17,16,15},
				{-4,-4,-4,-4,-4,-4,34,73,22,-3,-3,-3,-3,-3,-3},
				{-4,-4,-4,-4,-4,-4,33,72,23,-3,-3,-3,-3,-3,-3},
				{-4,-4,-4,-4,-4,-4,32,71,24,-3,-3,-3,-3,-3,-3},
				{-4,-4,-4,-4,-4,-4,31,70,25,-3,-3,-3,-3,-3,-3},
				{-4,-4,-4,-4,-4,-4,30,69,26,-3,-3,-3,-3,-3,-3},
				{-4,-4,-4,-4,-4,-4,29,28,27,-3,-3,-3,-3,-3,-3}};
		
		String[][] affichage = new String[15][15];
		int val=0;
		int val1=0;
		int val2 =0;
		int val3 = 0;
		int val4 = 0;
		Couleur cou= Couleur.BLANC;
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(plateauValeur[i][j]>=1 && plateauValeur[i][j]<=56) {
						val=plateauValeur[i][j]-1;
						if(caseChemin.get(val).getChevaux().size()>0) {
							for(Pion pi : caseChemin.get(val).getChevaux()) {
								cou=pi.getCouleur();
							}
							affichage[i][j]=Couleur.BLANC.getEcriture()+cou.getEcriture()+" "+caseChemin.get(val).getChevaux().size()+" "+ Couleur.BLANC.getEcriture();
						}
						else {
							affichage[i][j]=Couleur.BLANC.getCode()+"   "+ Couleur.BLANC.getCode();

						}
				}if(plateauValeur[i][j]==-1) {
					affichage[i][j]=Couleur.JAUNE.getCode()+"   "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]==-2) {
					affichage[i][j]=Couleur.BLEU.getCode()+"   "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]==-3) {
					affichage[i][j]=Couleur.ROUGE.getCode()+"   "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]==-4) {
					affichage[i][j]=Couleur.VERT.getCode()+"   "+ Couleur.BLANC.getCode();
				}
				
				
				
				else if(plateauValeur[i][j]>=75 &&plateauValeur[i][j]<=80 ) {
					val4=plateauValeur[i][j]-75;
					if(listeEchelles.get(0).get(val4).getChevaux().size()>0) {
						affichage[i][j]=Couleur.BLANC.getEcriture()+Couleur.JAUNE.getEcriture()+" ♞ "+Couleur.BLANC.getCode();
					}else {
						affichage[i][j]=Couleur.JAUNE.getCode()+"   "+ Couleur.BLANC.getCode();
					}	
				}
				
				
				
				else if(plateauValeur[i][j]>=69 && plateauValeur[i][j]<=74) {
					val2=plateauValeur[i][j]-69;
					if(listeEchelles.get(2).get(val2).getChevaux().size()>0) {
						affichage[i][j]=Couleur.BLANC.getEcriture()+Couleur.VERT.getEcriture()+" ♞ "+Couleur.BLANC.getCode();
					}else {
						affichage[i][j]=Couleur.VERT.getCode()+"   "+ Couleur.BLANC.getCode();

					}
				}
				
				
				else if(plateauValeur[i][j]>=63 && plateauValeur[i][j]<=68) {
					val1=plateauValeur[i][j]-63;
					if(listeEchelles.get(1).get(val1).getChevaux().size()>0) {
						affichage[i][j]=Couleur.BLANC.getEcriture()+Couleur.ROUGE.getEcriture()+" ♞ "+Couleur.BLANC.getCode();
					}else {
						affichage[i][j]=Couleur.ROUGE.getCode()+"   "+ Couleur.BLANC.getCode();

					}
				}
				
				
				
				else if(plateauValeur[i][j]>=90 && plateauValeur[i][j]<=95) {
					val3=plateauValeur[i][j]-90;
					if(listeEchelles.get(3).get(val3).getChevaux().size()>0) {
						affichage[i][j]=Couleur.BLANC.getEcriture()+Couleur.BLEU.getEcriture()+" ♞ "+Couleur.BLANC.getCode();
					}else {
						affichage[i][j]=Couleur.BLEU.getCode()+"   "+ Couleur.BLANC.getCode();
					}
				}
				
				
				
				else if(plateauValeur[i][j]==1000) {
					affichage[i][j]= "FIN";
				}
				
				
			}
		}
								

		for(int i=0;i<15;i++) {
			System.out.println();
			for(int j=0;j<15;j++) {
				System.out.print(affichage[i][j]);
				}
				
			}
		
		
		System.out.println();
	
		
	}
	
	public void deplacerPionA(Pion p, Case c) throws CasePleineException {
		
		for(CaseDeChemin cc : caseChemin) {
			for(Pion pion : cc.getChevaux()) {
				if(p==pion) {
					cc.retirerCheval(p);
					c.ajouteCheval(p);
					return ;
				}
			}
		}
		
		for(CaseEcurie ce : ecuries) {
			for(Pion pion : ce.getChevaux()) {
				if(p==pion) {
					ce.retirerCheval(p);
					c.ajouteCheval(p);
					return;
				}
			}
		}
		
		for(ArrayList<CaseDEchelle> le : listeEchelles) {
			for(CaseDEchelle cec : le) {
				for(Pion pion : cec.getChevaux()) {
					if(p==pion) {
						cec.retirerCheval(p);
						c.ajouteCheval(p);
						return;
					}
				}
			}
		}
		
		
		
	}

}
