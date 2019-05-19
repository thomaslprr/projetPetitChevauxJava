package mesExceptions;

public class ConflitDeCouleurException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflitDeCouleurException() {
		super("Plusieurs couleurs sont ensembles !");
	}

}
