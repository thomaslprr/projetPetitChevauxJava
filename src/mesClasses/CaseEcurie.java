package mesClasses;

import mesEnum.Couleur;

/**
 *  Classe pour les cases d'écurie. 
 *  Cette classe hérite de CaseColorée
 * @author thomaslapierre
 *
 */
public class CaseEcurie extends CaseColoree {
	public CaseEcurie(Couleur cou) {
		super(cou);
	}

	@Override
	public boolean peutPasser(Pion pion) {
		if(pion.getCouleur() == this.getCouleur())
            return true;
        else
            return false;
	}

	@Override
	public boolean peutSArreter(Pion pion) {
		if(pion.getCouleur() == this.getCouleur())
            return true;
        else
            return false;
	}

}
