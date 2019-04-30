package mesClasses;

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
}
