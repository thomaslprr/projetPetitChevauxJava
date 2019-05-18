package mesClasses;

import java.util.ArrayList;

import mesEnum.Couleur;

/**
 * Classe pour les joueurs humains. 
 * Cette classe est faite pour les joueurs qui ne sont pas des bots.
 * @author thomaslapierre
 *
 */
public class JoueurHumain extends Joueur {

	
	public JoueurHumain(String nom, Couleur cou) {
		super(nom,cou);
	}
	
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
		
		
	public boolean depasseTour(Pion pi, int de, Plateau pla) {
		
		int numFuturCase;
		for(CaseDeChemin cdc : pla.getChemin()) {
			for(Pion pio : cdc.getChevaux()) {
				if(pi==pio) {
						numFuturCase = pla.getChemin().indexOf(cdc)+de;
						
						if(pi.getCouleur()==Couleur.BLEU ) {
							if(numFuturCase>55 && pla.getChemin().indexOf(cdc)<=55) {
								return true;
							}else {
								return false;
							}
						}else if (pi.getCouleur()==Couleur.VERT ) {
							if(numFuturCase>27 && pla.getChemin().indexOf(cdc)<=27) {

								return true;
							}else {
								return false;
							}
						}else if(pi.getCouleur()==Couleur.JAUNE ) {
							if(numFuturCase>41 && pla.getChemin().indexOf(cdc)<=41) {

								return true;
							}else {
								return false;
							}
						}else if(pi.getCouleur()==Couleur.ROUGE ) {
							if(numFuturCase>13 && pla.getChemin().indexOf(cdc)<=13) {

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

	public boolean peutMonterEchelle(Pion pi, int de, Plateau pla) {
		for(CaseDeChemin cdc : pla.getChemin()) {
			for(Pion pio : cdc.getChevaux()) {
				if(pi==pio) {						
						if(pi.getCouleur()==Couleur.BLEU ) {
							if(pla.getChemin().indexOf(cdc)==55 && de==1) {
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
							if(pla.getChemin().indexOf(cdc)<=41 && de==1) {

								return true;
							}else {
								return false;
							}
						}else if(pi.getCouleur()==Couleur.ROUGE ) {
							if(pla.getChemin().indexOf(cdc)<=13 && de==1) {

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
							if(savoirPositionEchelle(pla,pi)+1==de && listeechelle.get(caseApres).peutSArreter(pi)){
								choixPossible.add(pi);
							}
						}
					}	
				}
			}
			
			
			
			
			
		}
		
		
		
		
		
		
	
		
		
		
		if(choixPossible.size()>0) {
			System.out.println("Quel pion voulez-vous déplacer parmis les suivants ?");
			for(int i=0;i<choixPossible.size();i++) {
				System.out.println(choixPossible.get(i).getId()+" : "+"Pion "+choixPossible.get(i).getId());
			}
			choix=Partie.sc.nextInt();
			return this.getPions().get(choix-1);
		}else {
			return null;
		}
	

	
	}
}
