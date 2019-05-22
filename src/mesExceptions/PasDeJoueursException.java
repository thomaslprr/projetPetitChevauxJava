package mesExceptions;

public class PasDeJoueursException extends Exception {

	/**
	 * Exception lorsque aucun joueur n'est passé en paramètre pour l'initialisation
	 * Il faut obligatoirement initialiser un joueur.
	 */
	private static final long serialVersionUID = 1L;

	public PasDeJoueursException() {
		super("Vous n'avez passé aucun joueur en paramètre.");
	}

}
