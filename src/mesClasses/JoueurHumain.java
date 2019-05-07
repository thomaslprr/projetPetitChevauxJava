package mesClasses;

import java.util.ArrayList;
import java.util.Scanner;

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
	public Pion choisirPion(int de, Plateau pla) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pion> choixPossible = new ArrayList<Pion>();
		
		
		
		
		
		
		
		
		
		
		System.out.println("Quel pion voulez-vous déplacer parmis les suivants ?");
		
		
		
		return null;
	}
}
