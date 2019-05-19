package mesClasses;


import mesExceptions.PasDeJoueursException;

/**
 * Classe pour les petits chevaux. Il s'agit du main du programme.
 * @author Thomas Lapierre
 *
 */
public class PetitsChevaux {

	public PetitsChevaux() {
		
	}

	public static void main(String[] args) throws PasDeJoueursException {
		/**
		 * On créé une partie 
		 */
		Partie p1 = new Partie();
		/**
		 * On joue et continue de jouer tant que les 4 pions d'un des joueurs ne sont pas sur l'échelle correspondante à la couleur du joueur de ces 4 pions
		 */
			do {
				p1.jouerUnTour();
			}while(p1.estPartieTermine()==false);
		System.out.println("La partie est terminée !");
	}

}
