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

	@Override
	public Pion choisirPion(int num, Plateau pla) {
		
		return null;
	}
}
