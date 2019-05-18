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
						}else {
							
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
						if(erreurTrajet==false) {
							choixPossible.add(pi);
						}
						
					}
				}
			}
			
			int caseApres;
			for(ArrayList<CaseDEchelle> listeechelle : pla.getEchelles()) {
				for(CaseDEchelle cde : listeechelle) {
					caseApres = pla.getChemin().indexOf(cde)+1;
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
