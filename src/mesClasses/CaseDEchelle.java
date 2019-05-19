package mesClasses;

import mesEnum.Couleur;
import mesExceptions.ConflitDeCouleurException;

/**
 *  Classe pour les cases d'échelle
 * @author Thomas Lapierre
 * Cette classe hérite de la classe CaseColoree
 */
public class CaseDEchelle extends CaseColoree {

	private static int compteurCaseDEchelle = 1 ;
	private int numero; 
	public boolean doitSArreter=false;
	
	/**
	 * Constructeur d'une case d'échelle, créé une case puis lui attribut une couleur. 
	 * Elles sont numérotées de 1 à 6.
	 * @param cou Couleur
	 * @throws ConflitDeCouleurException Elle peut lever une exception si une altercation entre les différentes couleurs à lieu.
	 */
	public CaseDEchelle(Couleur cou) throws ConflitDeCouleurException {
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
	/**
	 * 
	 * @return numéro de la case d'échelle
	 */
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
