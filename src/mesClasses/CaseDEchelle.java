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
	public boolean doitSArreter=false;
	public CaseDEchelle(Couleur cou) {
		super(cou);
		if(compteurCaseDEchelle==6) {
			numero=compteurCaseDEchelle;
			doitSArreter=true;
			compteurCaseDEchelle=1;
		}else {
			numero=compteurCaseDEchelle;
			compteurCaseDEchelle++;
		}
	}
	
	public int getNumeroCaseEchelle() {
		return numero;
	}

	@Override
	public boolean peutPasser(Pion pion) {
		if(this.getChevaux().size()>0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean peutSArreter(Pion pion) {
		if(this.getChevaux().size()>0) {
			return false;
		}else if(doitSArreter==true) {
			return false;
		}
		return true;
	}

}
