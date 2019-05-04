package mesClasses;

import mesEnum.Couleur;

/**
 *  Classe pour les cases d'échelle
 * @author thomaslapierre
 * Cette classe hérite de la classe CaseColoree
 */
public class CaseDEchelle extends CaseColoree {

	private static int compteurCaseDEchelle = 1 ;
	private int numero; 
	public CaseDEchelle(Couleur cou) {
		super(cou);
		if(compteurCaseDEchelle==6) {
			numero=compteurCaseDEchelle;
			compteurCaseDEchelle=1;
		}else {
			numero=compteurCaseDEchelle;
			compteurCaseDEchelle++;
		}
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
