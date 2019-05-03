package mesExceptions;

public class PasDeJoueursException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasDeJoueursException() {
		super("Vous n'avez passé aucun joueur en paramètre.");
	}

}
