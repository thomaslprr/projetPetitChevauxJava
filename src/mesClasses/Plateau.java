package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;

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
		ecuries.add(new CaseEcurie(Couleur.JAUNE));
		ecuries.add(new CaseEcurie(Couleur.ROUGE));
		ecuries.add(new CaseEcurie(Couleur.VERT));
		ecuries.add(new CaseEcurie(Couleur.BLEU));
		
		/**
		 * création des 6 cases d'échelles que l'on regroupe ensemble pour former une échelle d'une couleur spécifique
		 */
		
		for(int i=0;i<6;i++) {
			echelleRouge.add(new CaseDEchelle(Couleur.ROUGE));
		}
		
		
		for(int i=0;i<6;i++) {
			echelleJaune.add(new CaseDEchelle(Couleur.JAUNE));
		}
		
		
		for(int i=0;i<6;i++) {
			echelleBleu.add(new CaseDEchelle(Couleur.BLEU));
		}
		
		
		for(int i=0;i<6;i++) {
			echelleVert.add(new CaseDEchelle(Couleur.VERT));
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
				{-11,-1,-1,-1,-1,-1,55,56,1,-2,-2,-2,-2,-2,-22},
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
				{-44,-4,-4,-4,-4,-4,29,28,27,-3,-3,-3,-3,-3,-33}};
		
		String[][] affichage = new String[15][15];
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(plateauValeur[i][j]>=1 && plateauValeur[i][j]<=56) {
					affichage[i][j]= "  " ;
				}if(plateauValeur[i][j]==-1) {
					affichage[i][j]=Couleur.JAUNE.getCode()+"  "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]==-2) {
					affichage[i][j]=Couleur.BLEU.getCode()+"  "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]==-3) {
					affichage[i][j]=Couleur.ROUGE.getCode()+"  "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]==-4) {
					affichage[i][j]=Couleur.VERT.getCode()+"  "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]>=75 && plateauValeur[i][j]<=80) {
					affichage[i][j]=Couleur.VERT.getCode()+"  "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]>=69 && plateauValeur[i][j]<=74) {
					affichage[i][j]=Couleur.JAUNE.getCode()+"  "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]>=63 && plateauValeur[i][j]<=68) {
					affichage[i][j]=Couleur.ROUGE.getCode()+"  "+ Couleur.BLANC.getCode();
				}else if(plateauValeur[i][j]>=90 && plateauValeur[i][j]<=95) {
					affichage[i][j]=Couleur.BLEU.getCode()+"  "+ Couleur.BLANC.getCode();
				}
				else {
					affichage[i][j]=Couleur.BLANC.getCode()+ "  " + Couleur.BLANC.getCode();
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
	
	public void deplacerPionA(Pion p, Case c) {
		
		for(CaseDeChemin cc : caseChemin) {
			for(Pion pion : cc.getChevaux()) {
				if(pion==p) {
					cc.retirerCheval(p);
				}
			}
		}
		
		for(CaseEcurie ce : ecuries) {
			for(Pion pion : ce.getChevaux()) {
				if(pion==p) {
					ce.retirerCheval(p);
				}
			}
		}
		
		for(ArrayList<CaseDEchelle> le : listeEchelles) {
			for(CaseDEchelle cec : le) {
				for(Pion pion : cec.getChevaux()) {
					if(pion==p) {
						cec.retirerCheval(p);
					}
				}
			}
		}
		
		
		c.ajouteCheval(p);
	}

}
