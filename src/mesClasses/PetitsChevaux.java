package mesClasses;


import mesExceptions.PasDeJoueursException;

/**
 * Classe pour les petits chevaux.
 * @author Thomas Lapierre
 *
 */
public class PetitsChevaux {

	public PetitsChevaux() {
		
	}

	public static void main(String[] args) throws PasDeJoueursException {
		
		Partie p1 = new Partie();
		
			do {
				p1.jouerUnTour();
			}while(p1.estPartieTermine()==false);
		System.out.println("La partie est terminée !");
	}

}
