package mesExceptions;

public class ConflitDeCouleurException extends Exception {

	/**
	 * Exception lorsque plus couleurs sont mélangées ensemble
	 */
	private static final long serialVersionUID = 1L;

	public ConflitDeCouleurException() {
		super("Plusieurs couleurs sont ensembles !");
	}

}
