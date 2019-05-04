package mesClasses;

import mesEnum.Couleur;

/**
 *  Classe pour les cases d'échelle
 * @author thomaslapierre
 * Cette classe hérite de la classe CaseColoree
 */
public class CaseDEchelle extends CaseColoree {

	public CaseDEchelle(Couleur cou) {
		super(cou);
	}

	@Override
	public boolean peutPasser(Pion pion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean peutSArreter(Pion pion) {
		// TODO Auto-generated method stub
		return false;
	}

}
