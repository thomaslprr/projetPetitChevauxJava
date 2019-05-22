package mesClasses;

import mesEnum.Couleur;
import mesExceptions.ConflitDeCouleurException;

/**
 *  Classe pour les cases d'écurie. 
 *  Cette classe hérite de CaseColorée
 * @author thomaslapierre
 *
 */
public class CaseEcurie extends CaseColoree {
	/**
	 * Constructeur d'une case d'écurie
	 * @param cou couleur
	 * @throws ConflitDeCouleurException exception de couleur
	 */
	public CaseEcurie(Couleur cou) throws ConflitDeCouleurException {
		super(cou);
	}

	@Override
	/**
	 * Un pion peut passer sur une case d'écurie que s'il s'agit de sa propre écurie donc qu'ils ont la même couleur.
	 */
	public boolean peutPasser(Pion pion) {
		if(pion.getCouleur() == this.getCouleur())
            return true;
        else
            return false;
	}

	@Override
	/**
	 * Un pion peut s'arrête sur une case d'écurie que s'il s'agit de la sienne. 
	 * Par conséquent qu'ils aient la même couleur.
	 */
	public boolean peutSArreter(Pion pion) {
		if(pion.getCouleur() == this.getCouleur())
            return true;
        else
            return false;
	}

}
