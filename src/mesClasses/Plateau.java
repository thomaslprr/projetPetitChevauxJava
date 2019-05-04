package mesClasses;

import java.util.ArrayList;

public class Plateau {

	private ArrayList<ArrayList<CaseDEchelle>> echelles ;
	private final CaseDeChemin[] caseChemin;
	
	public Plateau() {
		caseChemin = new CaseDeChemin[56]; //case principale
		 for(int i=0; i<caseChemin.length; i++) {
                 caseChemin[i]=new CaseDeChemin();
             }
		
	}
	
	
	
	public ArrayList<ArrayList<CaseDEchelle>> getEchelles() {
		return echelles;
	}

	public ArrayList<CaseEcurie> getEcuries(){
		return null;
	}
	
	public ArrayList<CaseDeChemin> getChemin(){
		
		return null;
	}


	public void afficher() {
		
	}
	
	public void deplacerPionA(Pion p, Case c) {
		
		
	}

}
