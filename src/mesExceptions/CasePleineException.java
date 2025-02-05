package mesExceptions;

public class CasePleineException extends Exception {

	/**
	 * Exception lorsqu'une case est pleine
	 */
	private static final long serialVersionUID = 1L;

	public CasePleineException() {
		super("La case est pleine, le déplacement ne peut ainsi avoir lieu.");
	}

}
