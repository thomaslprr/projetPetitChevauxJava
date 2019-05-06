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
