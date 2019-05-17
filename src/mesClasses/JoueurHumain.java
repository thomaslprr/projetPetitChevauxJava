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
		
		
		
	

	@Override
	public Pion choisirPion(int de, Plateau pla) {

		ArrayList<Pion> choixPossible = new ArrayList<Pion>();
		int choix=-1;
		for(CaseEcurie ce : pla.getEcuries()) {
			if(this.getPions().size()==4 && ce.getCouleur()==this.getCouleur()) {
				if(de==6) {
					choixPossible.add(this.getPions().get(0));
					choixPossible.add(this.getPions().get(1));
					choixPossible.add(this.getPions().get(2));
					choixPossible.add(this.getPions().get(3));
				}
				else {
					return null;
				}
			}
		}
		
		
		
	
		
		
		
		
		
		
		
		System.out.println("Quel pion voulez-vous déplacer parmis les suivants ?");
		for(int i=0;i<choixPossible.size();i++) {
			System.out.println((i+1)+" : "+"Pion n°"+(i+1));
		}
		choix=Partie.sc.nextInt();
		
		return this.getPions().get(choix-1);

	
	}
}
