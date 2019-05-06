package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;

public class Plateau {

	private ArrayList<ArrayList<CaseDEchelle>> listeEchelles = new ArrayList<ArrayList<CaseDEchelle>>();
	private ArrayList<CaseDeChemin> caseChemin = new ArrayList<CaseDeChemin>();
	private ArrayList<CaseDEchelle> echelleRouge = new ArrayList<CaseDEchelle>();
	private ArrayList<CaseDEchelle> echelleJaune = new ArrayList<CaseDEchelle>();
	private ArrayList<CaseDEchelle> echelleBleu = new ArrayList<CaseDEchelle>();
	private ArrayList<CaseDEchelle> echelleVert = new ArrayList<CaseDEchelle>() ;
	private ArrayList<CaseEcurie> ecuries = new ArrayList<CaseEcurie>();
	
	public Plateau() {
		
		 for(int i=0; i<56; i++) {
                 caseChemin.add(new CaseDeChemin());
             }
		 
		
		ecuries.add(new CaseEcurie(Couleur.JAUNE));
		ecuries.add(new CaseEcurie(Couleur.ROUGE));
		ecuries.add(new CaseEcurie(Couleur.VERT));
		ecuries.add(new CaseEcurie(Couleur.BLEU));
		
		
		
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
